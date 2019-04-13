/**
 * 
 */
package ECS_Goods.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yueqiulin
 *
 */
@Controller
public class pageController {
	
	@RequestMapping("/{pageName}.html")
	public String toPage(@PathVariable("pageName") String name) {
		return name;
	}
	@RequestMapping("/manage")
	public String hrefFunction(@RequestParam("pageIndex") int pageIndex, 
			HttpServletRequest request) {
		HttpSession session=request.getSession();
		String url="store";
		switch (pageIndex) {
		case 0:   //店铺中心
			 url="store"; break;
		case 1:   //商品入库
			 url="goodsSku"; break;
		case 2:   //商品管理
			 url="goodsList"; break;
		case 3:   //订单管理
			 url="userOrder"; break;
		case 4:   //店铺中心
			 url="userComment"; break;
		case 5:   //店铺中心
			 url="saleStatistics"; break;	
		case 6:   //商品上下架
			 url="goodsSpu"; break;	 
		default:  url="store";
			break;
		}
	session.setAttribute("pageURL", url);
	return "manage";
	}

}
