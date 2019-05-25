/**
 * 
 */
package ECS_Logistics.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ECS_Logistics.entity.logisticsOrder;
import ECS_Logistics.entity.shippingInfo;

/**
 * @author yueqiulin
 *
 */

@Mapper
public interface logisticsMapper {
     public int addLogisticsOrder(logisticsOrder o);
     public int addShippingInfo(shippingInfo si);
     public int updateOrder(@Param("id") Integer id,@Param("status") Integer status); 
}
