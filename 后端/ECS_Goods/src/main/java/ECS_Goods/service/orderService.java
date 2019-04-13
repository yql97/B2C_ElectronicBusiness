/**
 * 
 */
package ECS_Goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
