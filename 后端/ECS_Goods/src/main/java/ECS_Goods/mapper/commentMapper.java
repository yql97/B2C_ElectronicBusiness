/**
 * 
 */
package ECS_Goods.mapper;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.goodsComment;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface commentMapper {
	   public int addGoodsComment(goodsComment comment);
}
