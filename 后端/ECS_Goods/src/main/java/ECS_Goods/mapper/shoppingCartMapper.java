/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

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
      public List<shopCartBaseInfo> getShopCartList(Integer user_id);
      public shopCartBaseInfo getShopCartGoods(Integer id);
      public List<goodsPropertyInfo>  getGoodsProperty(Integer id);
      public int deleteShopCart(Integer id);
}
