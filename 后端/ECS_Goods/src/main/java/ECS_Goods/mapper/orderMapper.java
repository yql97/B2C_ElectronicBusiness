/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
	   public List<orderBaseInfo> getOrderList();
	   public int addOrder(order o);
	   public List<storeOrderInfo> getStoreOrderList(Integer id);
}
