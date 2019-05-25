/**
 * 
 */
package ECS_Goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ECS_Goods.entity.browseRecordInfo;
import ECS_Goods.mapper.browseMapper;

/**
 * @author yueqiulin
 *
 */
@Service
public class browseRecordService {
     @Autowired
     private browseMapper bm;
     
     public List<browseRecordInfo> getBrowseRecordList(Integer userid){
    	return bm.getUserBrowseGoods(userid);
    	
     }
     public int deleteBrowseRecordInfo() {
    	 return 0;
     }
}
