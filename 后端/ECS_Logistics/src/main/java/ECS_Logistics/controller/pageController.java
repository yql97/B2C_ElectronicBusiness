/**
 * 
 */
package ECS_Logistics.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yueqiulin
 *
 */
@Controller
public class pageController {
	
	@RequestMapping("/manage")
	public String hrefFunction(@RequestParam("pageIndex") int pageIndex, HttpServletRequest request) {
		HttpSession session=request.getSession();
		String url="store";
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


}
