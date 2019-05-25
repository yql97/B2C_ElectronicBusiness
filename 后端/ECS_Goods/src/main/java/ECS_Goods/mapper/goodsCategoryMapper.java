/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.goodsCategory;
import ECS_Common.entity.goodsFamily;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface goodsCategoryMapper {
       public int addGoodsFamily(goodsFamily gf);
       public int addGoodsCategory(goodsCategory gc);
       public List<goodsFamily> getGoodsFamilyList(Integer sequence); 
       public List<goodsCategory> getGoodsCategory(goodsCategory gc);
       public List<goodsFamily> getAllGoodsFamily();
       public List<goodsCategory> getCategoryBySequence(Integer id);
}
