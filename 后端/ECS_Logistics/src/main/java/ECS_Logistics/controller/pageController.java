/**
 * 
 */
package ECS_Logistics.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

import ECS_Common.util.API;
import ECS_Common.util.RequestResult;
import ECS_Common.util.httpClient;
import ECS_Common.util.randomID;
import ECS_Logistics.entity.logisticsOrder;
import ECS_Logistics.entity.shippingInfo;
import ECS_Logistics.service.logisticsService;

/**
 * @author yueqiulin
 *
 */
@Controller
public class pageController {
	@Autowired
	private logisticsService ls;
	
	@RequestMapping(value="/login",method= RequestMethod.POST,produces="text/html;charset=UTF-8")
	public String login(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    System.out.println(username+password);
	   if(username.equals("物流人员")&&password.equals("123456")) {
		request.getSession().setAttribute("pageURL", "logisticsOrder");
		return "manage";
		}else {
			 response.setCharacterEncoding("UTF-8");
		    	response.getWriter().append("<script>alert('密码错误');</script>");
	   return "index"; }
	}
	
	@RequestMapping("/manage")
	public String hrefFunction(@RequestParam("pageIndex") int pageIndex, HttpServletRequest request) {
		HttpSession session=request.getSession();
		String url="logisticsList";
		switch (pageIndex) {
		case 0:   //创建订单
			 url="logisticsOrder"; break;
		case 1:   //物流订单列表
			 url="logisticsList"; break;
		case 2:   //物流信息更新
			 url="logisticsInfo"; break;
		case 3:   //配送信息填写
			 url="logisticsEnd"; break;	 
		default:  url="logisticsList";
			break;
		}
	session.setAttribute("pageURL", url);
	return "manage";
	}
    @RequestMapping(value="addLogistics",method= RequestMethod.POST,produces="text/html;charset=UTF-8")
    public String add(@ModelAttribute logisticsOrder o,@ModelAttribute shippingInfo si,
    		HttpServletRequest req,HttpServletResponse res) throws IOException {
    	req.setCharacterEncoding("UTF-8");
    	si.setId(randomID.createRandomID());
    	o.setShipping_info_id(si.getId());
    	o.setLogistics_order_code(randomID.createRandomID());
    	   ls.createLogisticsOrder(o, si);
    	   ls.updateOrder(o.getOrder_id(),3);
    	   res.setCharacterEncoding("UTF-8");
	    	res.getWriter().append("<script>alert('添加成功');</script>");
	    	return "manage";
    }

}
