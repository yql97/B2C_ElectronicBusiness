/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.goods_sku;
import ECS_Goods.entity.goodsBaseInfo;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface goodsSkuMapper {
	   public goodsBaseInfo getGoodsBaseInfo(Integer id);
	   public goods_sku getGoodsSku(Integer id);
	   public List<goods_sku> getGoodsSkuList(Integer id);
	   public List<goods_sku> getAllGoodsSkuList();
       public int addGoodsSku(goods_sku  gs);
       public int updateGoodsSku(goods_sku gs);
}
