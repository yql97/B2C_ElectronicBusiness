/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ECS_Common.entity.order;
import ECS_Goods.entity.goodsPropertyInfo;
import ECS_Goods.entity.orderBaseInfo;
import ECS_Goods.entity.storeOrderInfo;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface orderMapper {
	   public goodsPropertyInfo getGoodsProperty(Integer id);
	   public orderBaseInfo getOrderBaseInfo(Integer id);
	   public List<orderBaseInfo> getOrderList(@Param("id") Integer id,@Param("status") Integer status);
	   public int addOrder(order o);
	   public List<storeOrderInfo> getStoreOrderList(Integer id);
	   public int updateOrder(@Param("id") Integer id,@Param("status") Integer status);
}
