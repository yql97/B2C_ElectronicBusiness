/**
 * 
 */
package ECS_Goods.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ECS_Goods.entity.goodsBaseInfo;
import ECS_Goods.mapper.goodsSkillMapper;

/**
 * @author yueqiulin
 *
 */
@Service
public class goodsSkillService {
       @Autowired
       private goodsSkillMapper gsm;
       
       public List<goodsBaseInfo> getSkillGoodsList(Date start,Date end){
    	   gsm.getSkillGoods(start, end);
    	   return null;
       }
}
