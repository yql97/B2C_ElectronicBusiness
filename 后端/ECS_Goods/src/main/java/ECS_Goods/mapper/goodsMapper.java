/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.goods;
import ECS_Goods.entity.storeGoodsInfo;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface goodsMapper {
	   public  List<goods> getAllGoods(); 
       public int insertGoods(goods g);
       public List<goods> selectByStoreId(Integer id);
       public goods getGoodsById(Integer id);
       public int updateGoods(goods g);
       public int deleteGoods(Integer goods_id);
       public List<storeGoodsInfo> getStoreGoodsList(Integer id);
}
