/**
 * 
 */
package ECS_Goods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ECS_Common.entity.store;
import ECS_Goods.mapper.storeMapper;

/**
 * @author yueqiulin
 *
 */

@Service
public class storeService {
   @Autowired
   private storeMapper sm;
   
   public store getStoreInfo(Integer store_id) {
	   return sm.getStoreInfo(store_id);
   }
   
   public int addStore(store s) {
	   int row=sm.addStore(s);
	   if(row>0) return row;
	   return 0;
   }
}
