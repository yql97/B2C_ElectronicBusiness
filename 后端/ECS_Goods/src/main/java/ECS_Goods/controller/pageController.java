/**
 * 
 */
package ECS_Goods.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import ECS_Common.entity.goods;
import ECS_Common.entity.goodsFamily;
import ECS_Common.entity.goodsPropertyName;
import ECS_Common.entity.goodsPropertyValue;
import ECS_Common.entity.store;
import ECS_Common.util.API;
import ECS_Common.util.RequestResult;
import ECS_Common.util.httpClient;
import ECS_Goods.entity.commentInfo;
import ECS_Goods.entity.goodsData;
import ECS_Goods.entity.goodsPropertyInfo;
import ECS_Goods.entity.storeGoodsInfo;
import ECS_Goods.entity.storeGoodsSaleInfo;
import ECS_Goods.entity.storeOrderInfo;
import ECS_Goods.service.goodsCategoryService;
import ECS_Goods.service.goodsService;
import ECS_Goods.service.orderService;
import ECS_Goods.service.storeService;
import ECS_Goods.util.RedisUtils;
import ECS_Goods.util.autherInfo;

/**
 * @author yueqiulin
 *
 */
@Controller
public class pageController {
	 @Autowired
	    private goodsService gs;
	 @Autowired
	 private goodsCategoryService gcs;
	 @Autowired
	 private RedisUtils redisUtil;
	    @Autowired
	    private orderService os;
	    @Autowired
	    private storeService ss;
	    @Autowired
	    private autherInfo auth;
	/*@RequestMapping("/{pageName}.html")
	public String toPage(@PathVariable("pageName") String name) {
		return name;
	}*/
	@RequestMapping(value="/login",method= RequestMethod.POST,produces="text/html;charset=UTF-8")
	public String login(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    System.out.println(username+password);
	    Map<String,Object> map=new HashMap<String,Object>();
	    map.put("username", username);
	    map.put("userpassword",password);
	    map.put("sessionID", "");
	    String result=httpClient.httpClientPost(API.ECS_User+"/login.action",map);
	    JSONObject o=JSONObject.parseObject(result);
	    if(o.get("result_object").toString().equals("失败")) { 
	    	response.setCharacterEncoding("UTF-8");
	     	response.getWriter().append("<script>alert('用户名密码错误');</script>");
	     	return "index";
	    }
	    JSONObject o2=JSONObject.parseObject(o.get("result_object").toString());
	    String sessionid=o2.get("sessionID").toString();
	    RequestResult res=auth.getBusiness(Integer.parseInt(sessionid));
	    if(res.getResult_object().equals("失败")&&res.getResult_code()==400){
	    response.setCharacterEncoding("UTF-8");
    	response.getWriter().append("<script>alert('该系统只能商家登录使用');</script>");
    	return "index";
	    }
	    HttpSession session=request.getSession();
	    Cookie c=new Cookie("sessionID",sessionid);
	    response.addCookie(c);
		  getUserStore(request,sessionid);
		session.setAttribute("pageURL", "store");
		return "manage";
	}
	@RequestMapping("/manageStore")
	public String hrefFunction(HttpServletRequest request,HttpServletResponse response) throws IOException{
		  //HttpSession session=request.getSession();
		 String  data=auth.getAuther(request);
		    if(data.equals("index")) {
		    	return data;
		    } 
		  getUserStore(request,data);
		 request.getSession().setAttribute("pageURL", "store");
	return "manage";
	}
	@RequestMapping("/manageGoodsSku")
	public String manageGoodsSku(HttpServletRequest request) throws IOException {
		String  data=auth.getAuther(request);
	    if(data.equals("index")) {
	    	return data;
	    } 
	    RequestResult o= auth.getBusiness(Integer.parseInt(data));
		  JSONObject jo=JSONObject.parseObject(o.getResult_object().toString());
		 List<goods> goodsList=gs.getStoreGoods(Integer.parseInt(jo.get("store_id").toString()));
		 List<goodsPropertyName> gpnList=new ArrayList<goodsPropertyName>();
		 List<goodsPropertyValue> gpvList=new ArrayList<goodsPropertyValue>();
		 for(goods g:goodsList) {
			 List<goodsPropertyName> list=gs.getPropertyNameList(g.getCategory_Id());
			 gpnList.addAll(list);
		 }
		 for(goodsPropertyName gp:gpnList) {
			 List<goodsPropertyValue> list  =gs.getPropertyValueList(gp.getPropertyName_id());
			 gpvList.addAll(list);
		 }
		 request.getSession().setAttribute("propertyNameList",gpnList);
		 request.getSession().setAttribute("propertyValueList",gpvList);
		 request.getSession().setAttribute("goodsList",goodsList);
	     request.getSession().setAttribute("pageURL", "goodsSku");
		return "manage";
	}
	@RequestMapping("/manageGoodsSpu")
	public String manageGoodsSpu(HttpServletRequest request) throws IOException {
		   List<goodsFamily> gflist=gcs.getAllGoodsFamily();
		 request.getSession().setAttribute("goodsFamilyList",gflist);  
	     request.getSession().setAttribute("pageURL", "goodsSpu");
		return "manage";
	}
	@RequestMapping("/manageGoodsList")
	public String manageGoodsList(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String  data=auth.getAuther(request);
		System.out.println(data);
	    if(data.equals("index")) {
	    	return data;
	    }
		getStoreGoodsList(request,data);
	     request.getSession().setAttribute("pageURL", "goodsList");
		return "manage";
	}
	@RequestMapping("/manageOrderList")
	public String manageOrderList(HttpServletRequest request) throws IOException {
		String  data=auth.getAuther(request);
		getStoreOrderList(request,data);
	     request.getSession().setAttribute("pageURL", "userOrder");
		return "manage";
	}
	@RequestMapping("/manageComment")
	public String manageComment(HttpServletRequest request) throws IOException {
		getStoreCommentList(request);
	     request.getSession().setAttribute("pageURL", "userComment");
		return "manage";
	}
	@RequestMapping("/manageSaleStatistics")
	public String manageSaleStatistics(HttpServletRequest request) throws IOException {
		getStoreStatisticsList(request);
	     request.getSession().setAttribute("pageURL", "saleStatistics");
		return "manage";
	}
	public  void getStoreGoodsList(HttpServletRequest request,String user_id) throws IOException {
		//111111
	    RequestResult o= auth.getBusiness(Integer.parseInt(user_id));
		  JSONObject jo=JSONObject.parseObject(o.getResult_object().toString());
		  System.out.println(jo.get("store_id").toString());
	     List<storeGoodsInfo>  sgiList=gs.getStroeGoodsList(Integer.parseInt(jo.get("store_id").toString()));
	     System.out.println(sgiList.size());
	     //System.out.println(sgiList);
	     List<goodsData> goodsDataList = new ArrayList<goodsData>();
	     for(storeGoodsInfo sgi:sgiList) {
	  	   List<goodsPropertyInfo>  gpList=gs.getGoodsPropertyList(sgi.getGoods_sku_id());
	    	 goodsData gd=new goodsData(sgi,gpList);
	    	 goodsDataList.add(gd);
	     }
	     System.out.println(goodsDataList.size());
	     request.getSession().setAttribute("storeGoodsList",goodsDataList);
	}	
	  public void getStoreOrderList(HttpServletRequest request,String user_id) throws IOException {
		  RequestResult o= auth.getBusiness(Integer.parseInt(user_id));
		  JSONObject jo=JSONObject.parseObject(o.getResult_object().toString());
		  System.out.println(jo.get("store_id").toString());
          List<storeOrderInfo>  soiList	=os.getStoreOrderList(Integer.parseInt(jo.get("store_id").toString()));
          List<goodsData> goodsDataList = new ArrayList<goodsData>();
 	     for(storeOrderInfo soi:soiList) {
 	    	Map<String,Object> map=new HashMap<String,Object>();
	    	 map.put("receiveAddress_id", soi.getReceive_address_id());
	    	 map.put("sessionID",user_id);
	    	 String result=httpClient.httpClientGet(API.ECS_User+"/getReceiveAddressInfo.action",map);
	   		   RequestResult res=JSONObject.toJavaObject(JSONObject.parseObject(result),RequestResult.class);
	    	    System.out.println(res.getResult_object().toString());
	    	    JSONObject o2=JSONObject.parseObject(res.getResult_object().toString());
	    	    Map<String,String> map2=new HashMap<String,String>();
	    	    map2.put("address",o2.getString("district")+o2.getString("detailedAddress"));
	    	    map2.put("receiverName",o2.getString("receiverName"));
	    	    map2.put("receiverPhone",o2.getString("receiverPhone"));
	    	    soi.setReceive_address(map2);
	    	    soi.setBuyer_name(o2.getString("user_id"));
 	  	   List<goodsPropertyInfo>  gpList=gs.getGoodsPropertyList(soi.getGoods_sku_id());
 	  	  // System.out.println(gpList.toString());
 	    	 goodsData gd=new goodsData(soi,gpList);
 	    	// System.out.println(gd.toString());
 	    	 goodsDataList.add(gd);
 	     }
          request.getSession().setAttribute("storeOrder",goodsDataList);
          
          System.out.println(goodsDataList.toString());
      }
	  public void getStoreCommentList(HttpServletRequest request) throws IOException {
          List<commentInfo> ciList	=ss.getStoreCommentList(111111);
  	   request.getSession().setAttribute("storeComment",ciList);
          System.out.println(ciList.toString());
      }
	  public void getStoreStatisticsList(HttpServletRequest request) throws IOException {
        List<storeGoodsSaleInfo> sgsiList =ss.getStoreGoodsSaleList(111111);
  	   request.getSession().setAttribute("storeSaleStatistics",sgsiList);
          System.out.println(sgsiList.toString());
      }
	  public void getUserStore(HttpServletRequest request,String userid) throws IOException {
		  String user=redisUtil.get(userid).toString();
		  JSONObject u=JSONObject.parseObject(user);
		  RequestResult o= auth.getBusiness(Integer.parseInt(userid));
		  JSONObject jo=JSONObject.parseObject(o.getResult_object().toString());
		  store s=ss.getStoreInfo(Integer.parseInt(jo.get("store_id").toString()));
		  System.out.println(s);
		 HttpSession session= request.getSession();
		 session.setAttribute("username",u.get("username"));
		 session.setAttribute("storeInfo",s);
	      }
	  public void getUserName(HttpServletRequest request,HttpServletResponse response) throws IOException {
		  String  data=auth.getAuther(request);
		    if(data.equals("index")) {
		    	response.sendRedirect("/ECS_Goods/");
		    } 
		  String user=redisUtil.get(data).toString();
		  JSONObject u=JSONObject.parseObject(user);
		  request.getSession().setAttribute("username",u.get("username"));
	  }
}
