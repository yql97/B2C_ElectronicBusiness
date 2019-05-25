/**
 * 
 */
package ECS_Goods.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import ECS_Common.entity.order;
import ECS_Common.util.API;
import ECS_Common.util.ReqResultUtil;
import ECS_Common.util.RequestResult;
import ECS_Common.util.httpClient;
import ECS_Common.util.randomID;
import ECS_Goods.entity.orderBaseInfo;
import ECS_Goods.entity.storeOrderInfo;
import ECS_Goods.service.orderService;
import ECS_Goods.util.RedisUtils;

/**
 * @author yueqiulin
 *
 */
@Controller
public class orderController {
    @Autowired 
    private orderService os;
    @Autowired
    private RedisUtils redisUtils;
    
    @RequestMapping(value="/getUserOrderList",method=RequestMethod.GET)
    @ResponseBody
    public String getUserOrderList(HttpServletRequest req) {
    	String userid=req.getHeader("Authorization");
    	Integer status=Integer.parseInt(req.getParameter("status"));
    	if(redisUtils.get(userid)==null) return ReqResultUtil.getFailedResponse("去登录");
    	return ReqResultUtil.getSuccessResponse( os.getUserOrderList(Integer.parseInt(userid),status));
    }
    @RequestMapping(value="/getUserOrderInfo",method=RequestMethod.POST)
    @ResponseBody
    public String getUserOrderInfo(HttpServletRequest req) {
    	String userid=req.getHeader("Authorization");
    	System.out.println(userid);
    	String orderid=req.getParameter("orderid");
    	System.out.println(orderid);
    	if(redisUtils.get(userid)==null) return ReqResultUtil.getFailedResponse("去登录");
    	  orderBaseInfo obi = os.getOrderInfo(Integer.parseInt(orderid));
    	  if(obi==null) return ReqResultUtil.getFailedResponse();
    	  System.out.println(obi.toString());
    	 return ReqResultUtil.getSuccessResponse(obi);
    }
    
    /*@RequestMapping(value="getStoreOrderList",method=RequestMethod.GET)
    public void getStoreOrderList(HttpServletResponse response) throws IOException {
             List<storeOrderInfo>  soiList	=os.getStoreOrderList(111111);
             System.out.println(soiList.toString());
             response.sendRedirect("manage?pageIndex=2"); 
    }*/
    
    @RequestMapping(value="/createOrder",method=RequestMethod.POST)
    @ResponseBody
    public String createOrder(HttpServletRequest req) {
    	String userid=req.getHeader("Authorization");
    	if(redisUtils.get(userid)==null) return ReqResultUtil.getFailedResponse("去登录");
    	String num=req.getParameter("buynum");
    	String goods_sku_id=req.getParameter("goods_sku_id");
    	String remark=req.getParameter("remark");
    	String receiveAddressId=req.getParameter("receive_address_id");
    	System.out.println(userid+num+goods_sku_id);
    	System.out.println(remark+receiveAddressId);
    	order o=new order(randomID.createRandomID(),Integer.parseInt(userid),randomID.createRandomID(),
    			Integer.parseInt(goods_sku_id),0,new Date(),Integer.parseInt(num));
    	o.setBuyer_message(remark);
    	o.setReceive_address_id(Integer.parseInt(receiveAddressId));
    	int status=os.createOrder(o);
    	System.out.println(status);
    	if(status==1)  return ReqResultUtil.getSuccessResponse(o.getOrder_code());
    	return ReqResultUtil.getFailedResponse();
    }
    @RequestMapping(value="/remindPayment",method=RequestMethod.POST)
    @ResponseBody
    public String remindPayment(HttpServletRequest req) {   //确认支付
    	String userid=req.getHeader("Authorization");
    	if(redisUtils.get(userid)==null) return ReqResultUtil.getFailedResponse("去登录");
    	String payCode=req.getParameter("payCode");
    	String orderid=req.getParameter("orderid");
    	String password=req.getParameter("password");
    	System.out.println(payCode+orderid+password);
    	JSONObject o=JSONObject.parseObject(redisUtils.get(userid).toString());
    	String password0=o.getString("payPassword");
    	if(!password0.equals(password)) return ReqResultUtil.getFailedResponse("支付密码错误");
    	orderBaseInfo obi= os.getOrderInfo(Integer.parseInt(orderid));
    	if(payCode.equals("1")) {
    		Map<String,Object> map =new HashMap<String,Object>();
    		map.put("recive_account",obi.getStore_id());
    		map.put("pay_account",userid);
    		map.put("number",obi.getNew_price()*obi.getGoods_num());
    	   /*String result=httpClient.httpClientGet(API.ECS_User+"/transferAccounts.action",map);
   		   RequestResult res=JSONObject.toJavaObject(JSONObject.parseObject(result),RequestResult.class);
   		   if(res.getResult_code()==200) {  //付款成功
   			return ReqResultUtil.getSuccessResponse();
   		   }*/
    		//return ReqResultUtil.getFailedResponse();
    		return ReqResultUtil.getSuccessResponse();
    	}
    	Map<String,Object> map =new HashMap<String,Object>();
		map.put("account_num",obi.getStore_id());
		map.put("bankCard_num",payCode);
		map.put("number",obi.getNew_price()*obi.getGoods_num());
    	  /* String result=httpClient.httpClientGet(API.ECS_User+"/PayMoneyByBankCard.action",map);
   		   RequestResult res=JSONObject.toJavaObject(JSONObject.parseObject(result),RequestResult.class);
   		   if(res.getResult_code()==200) { //付款成功
   			   return ReqResultUtil.getSuccessResponse();
   		   }*/
    	//return ReqResultUtil.getFailedResponse();
		os.updateOrder(Integer.parseInt(orderid),1);
		return ReqResultUtil.getSuccessResponse();
    }
    
    @RequestMapping(value="markShipping",method=RequestMethod.GET) //标记发货
    public void markShipping(HttpServletResponse response,String id) throws IOException {
    	 os.updateOrder(Integer.parseInt(id),2);
    	response.sendRedirect("/ECS_Goods/manageOrderList");
    }
    
    @RequestMapping(value="/remindReceipt",method=RequestMethod.POST) //确认收货
    @ResponseBody
    public String remindReceipt(HttpServletRequest req) {
    	String userid=req.getHeader("Authorization");
    	if(redisUtils.get(userid)==null) return ReqResultUtil.getFailedResponse("去登录");
    	String orderid=req.getParameter("orderid");
    	if(os.updateOrder(Integer.parseInt(orderid),4)==1)
    		return ReqResultUtil.getSuccessResponse();
    	return ReqResultUtil.getFailedResponse();
    }
}
