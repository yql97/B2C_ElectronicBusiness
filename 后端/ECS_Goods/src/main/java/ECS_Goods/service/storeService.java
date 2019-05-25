/**
 * 
 */
package ECS_Goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import ECS_Common.entity.store;
import ECS_Common.util.API;
import ECS_Common.util.ReqResultUtil;
import ECS_Common.util.RequestResult;
import ECS_Common.util.httpClient;
import ECS_Goods.entity.commentInfo;
import ECS_Goods.entity.storeGoodsSaleInfo;
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
   public List<storeGoodsSaleInfo> getStoreGoodsSaleList(Integer id){
	   return sm.getGoodsSaleList(id);
   }
   public List<commentInfo> getStoreCommentList(Integer id){
	   return sm.getStoreCommentList(id);
   }
}
