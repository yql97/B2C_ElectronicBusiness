/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.goodsComment;
import ECS_Goods.entity.commentInfo;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface commentMapper {
	   public int addGoodsComment(goodsComment comment);
	   public List<commentInfo> getUserComment(Integer id);
	   public List<commentInfo> getGoodsComment(Integer id);
}
