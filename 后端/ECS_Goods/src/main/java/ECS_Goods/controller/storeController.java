/**
 * 
 */
package ECS_Goods.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ECS_Goods.entity.commentInfo;
import ECS_Goods.entity.storeGoodsSaleInfo;
import ECS_Goods.service.storeService;
import ECS_Goods.util.RedisUtils;

/**
 * @author yueqiulin
 *
 */
@Controller
public class storeController {
     	@Autowired
     	private storeService ss;
     	
     	@RequestMapping(value="/getStoreInfo",method= RequestMethod.GET)
     	public void getStoreInfo(HttpServletRequest req ) {
     		Integer userid=(Integer)req.getSession().getAttribute("sessionID");
     		
     		ss.getStoreInfo(userid);
     	}
     	
 /*    	@RequestMapping(value="/getStoreGoodsSaleList",method= RequestMethod.GET)
     	public void getStoreGoodsSaleList(HttpServletResponse response) throws IOException {
     		List<storeGoodsSaleInfo> sgsList =ss.getStoreGoodsSaleList(111111);
     		System.out.println(sgsList.toString());
     		response.sendRedirect("manage?pageIndex=2"); 
     	}
    	@RequestMapping(value="/getStoreCommentList",method= RequestMethod.GET)
    	public void getStoreCommentList(HttpServletResponse response) throws IOException{
    		List<commentInfo>  ciList=ss.getStoreCommentList(111111);
    		System.out.println(ciList.toString());
    		response.sendRedirect("manage?pageIndex=2"); 
    	}*/
     	@RequestMapping(value="/closeStore",method= RequestMethod.GET)
     	public void closeStore(){
     		
     	}
    	@RequestMapping(value="/openStore",method= RequestMethod.GET)
     	public void openStore(){
     		
     	}
    	@RequestMapping(value="/updateStoreInfo",method= RequestMethod.GET)
     	public void updateStoreInfo(){
     		
     	}
     	
}
