/**
 * 
 */
package ECS_Goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ECS_Common.entity.goodsComment;
import ECS_Goods.entity.commentInfo;
import ECS_Goods.mapper.commentMapper;

/**
 * @author yueqiulin
 *
 */
@Service
public class commentService {
          @Autowired
          private commentMapper cm;
           
          public int addUserComment(goodsComment comment) { //买家发表评论
        	  cm.addGoodsComment(comment);
        	  return 0;
          } 
          public int addBusinessComment() { //商家回复评论
        	  //cm.
        	  return 0;
          }
          public List<commentInfo> getGoodsCommentList(Integer id){ //根据goodsid得到
        	  return cm.getGoodsComment(id);
          }
          public List<commentInfo> getUserCommentList(Integer userid){
        	  return cm.getUserComment(userid);
          }
}
