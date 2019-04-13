/**
 * 
 */
package ECS_Goods.mapper;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.shopCart;
import ECS_Goods.entity.shopCartBaseInfo;
import ECS_Goods.entity.goodsPropertyInfo;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface shoppingCartMapper {
      public int addShopCart(shopCart sc);
      public shopCartBaseInfo getGoodsBaseInfo(Integer user_id);
      public goodsPropertyInfo  getGoodsProperty(Integer id);
      public int deleteShopCart(Integer id);
}
