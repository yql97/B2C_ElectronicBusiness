/**
 * 
 */
package ECS_Goods.mapper;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.goods_sku;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface goodsSkuMapper {
       public int addGoodsSku(goods_sku  gs);
       public int updateGoodsSku(goods_sku gs);
}
