/**
 * 
 */
package ECS_Goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ECS_Goods.service.commentService;

/**
 * @author yueqiulin
 *
 */
@Controller
public class commentController {
	@Autowired
	private commentService cs;
	
	@RequestMapping(value="/getStoreCommentList",method= RequestMethod.GET)
	public void getStoreCommentList(){
		
	}
	@RequestMapping(value="/replyComment",method= RequestMethod.POST)
	public void replyComment(){
		
	}
	
}
