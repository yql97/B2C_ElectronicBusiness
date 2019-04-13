/**
 * 
 */

package ECS_Goods.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ECS_Common.entity.goodsCategory;
import ECS_Common.entity.goodsFamily;
import ECS_Goods.mapper.goodsCategoryMapper;

/**
 * @author yueqiulin
 *
 */
@Service
public class goodsCategoryService {
	
       @Autowired
       private goodsCategoryMapper gcm;
       
       public int addGoodsCategory(goodsCategory gc) {
    	   return  gcm.addGoodsCategory(gc);
       }
       public int addGoodsFamily(goodsFamily gf) {
    	   return gcm.addGoodsFamily(gf);
       }
       
       public List<goodsFamily> getGoodsFamilyList(Integer sequence){
    	   return gcm.getGoodsFamilyList(sequence);
       }
       public List<goodsCategory>  getGoodsCategory(goodsCategory gc){
    	   return gcm.getGoodsCategory(gc);
       }
       
}
