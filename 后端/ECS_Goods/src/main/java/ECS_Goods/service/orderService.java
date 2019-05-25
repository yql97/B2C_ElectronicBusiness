/**
 * 
 */
package ECS_Goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ECS_Common.entity.order;
import ECS_Goods.entity.goodsPropertyInfo;
import ECS_Goods.entity.orderBaseInfo;
import ECS_Goods.entity.storeOrderInfo;
import ECS_Goods.mapper.orderMapper;

/**
 * @author yueqiulin
 *
 */
@Service
public class orderService {
    @Autowired
    private orderMapper om;
    
    public List<storeOrderInfo> getStoreOrderList(Integer id){
    	return om.getStoreOrderList(id);
    }
    public int createOrder(order o) {
    	return om.addOrder(o);
    }
    public int deleteOrder() {
    	return 0;
    }
    public List<orderBaseInfo> getUserOrderList(Integer id,Integer status){
    	return om.getOrderList(id,status);
    }
    public orderBaseInfo getOrderInfo(Integer id) {//根据订单id
    	return om.getOrderBaseInfo(id);
    }
    public goodsPropertyInfo getOrderGoodsProperty(Integer id) {
    	return om.getGoodsProperty(id);
    }
    public int updateOrder(int orderCode,int status) {
    	return om.updateOrder(orderCode, status);
    }
  /*  public Integer getBusinessByOrder(Integer orderid) {
    	orderBaseInfo obi=om.getOrderBaseInfo(orderid);
    	return obi.getStore_id();
    }*/
}
