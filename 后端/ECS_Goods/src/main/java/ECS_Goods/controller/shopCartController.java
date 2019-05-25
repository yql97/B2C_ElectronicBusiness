/**
 * 
 */
package ECS_Goods.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ECS_Common.entity.shopCart;
import ECS_Common.util.ReqResultUtil;
import ECS_Goods.entity.goodsData;
import ECS_Goods.service.shopCartService;
import ECS_Goods.util.RedisUtils;

/**
 * @author yueqiulin
 *
 */
@Controller
public class shopCartController {
        @Autowired
        private shopCartService scs;
        @Autowired
        private RedisUtils redisUtils;
        
        @RequestMapping(value="/getShopCartInfo",method= RequestMethod.GET)
        @ResponseBody
        public String getShopCartInfo() {
        	return ReqResultUtil.getSuccessResponse(scs.getShopCartGoods(1111));
        }
        @RequestMapping(value="/getShopCartList",method= RequestMethod.GET)
        @ResponseBody
        public String getShopCartList(HttpServletRequest req) {
        	String userid=req.getHeader("Authorization");
        	if(redisUtils.get(userid)==null) return ReqResultUtil.getFailedResponse("去登录");
        	List<goodsData> sdList=scs.getShopCartList(Integer.parseInt(userid));
        	System.out.println(sdList.toString());
        	return ReqResultUtil.getSuccessResponse(sdList);
        }
        
        @RequestMapping(value="/putShopCart",method= RequestMethod.POST)
        @ResponseBody
        public String putShopCart(HttpServletRequest req) {
        	String userid=req.getHeader("Authorization");
        	if(redisUtils.get(userid)==null) return ReqResultUtil.getFailedResponse("去登录");
        	String num=req.getParameter("buynum");
        	String goods_sku_id=req.getParameter("goods_sku_id");
        	System.out.println(userid+num+goods_sku_id);
        	shopCart sc=new shopCart();
        	sc.setGoods_num(Integer.parseInt(num));
        	sc.setGoods_sku_id(Integer.parseInt(goods_sku_id));
        	sc.setUser_id(Integer.parseInt(userid));
        	int status=scs.addToShopCart(sc);
        	if(status==1) {
        		return ReqResultUtil.getSuccessResponse();
        	}
        	return ReqResultUtil.getFailedResponse();
        }
        
}
