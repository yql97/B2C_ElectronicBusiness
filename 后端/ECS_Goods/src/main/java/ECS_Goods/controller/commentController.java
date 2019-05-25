/**
 * 
 */
package ECS_Goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ECS_Common.util.ReqResultUtil;
import ECS_Goods.entity.commentInfo;
import ECS_Goods.service.commentService;

/**
 * @author yueqiulin
 *
 */
@Controller
public class commentController {
	@Autowired
	private commentService cs;
	
	@RequestMapping(value="/replyComment",method= RequestMethod.POST)
	public void replyComment(commentInfo c){
		System.out.println(c);
		//cs.addBusinessComment();
	}
	@RequestMapping(value="/getGoodsComment",method= RequestMethod.GET)
	public String getGoodsCommentList() {
		cs.getGoodsCommentList(11111);
		return ReqResultUtil.getSuccessResponse();
	}
	@RequestMapping(value="/getUserComment",method= RequestMethod.GET)
	public String getUserCommentList() {
		cs.getUserCommentList(11111);
		return ReqResultUtil.getSuccessResponse();
	}
	@RequestMapping(value="/addUserComment",method= RequestMethod.POST)
	public String addUserComment(@ModelAttribute commentInfo c) {
		System.out.println(c.toString());
		//cs.addUserComment(null);
		return ReqResultUtil.getSuccessResponse();
	}
	
	
}
