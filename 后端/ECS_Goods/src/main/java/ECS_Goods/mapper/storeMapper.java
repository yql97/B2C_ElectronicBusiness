/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.store;
import ECS_Goods.entity.commentInfo;
import ECS_Goods.entity.storeGoodsSaleInfo;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface storeMapper {
          public store getStoreInfo(Integer store_id);
          public int addStore(store s);
          public List<storeGoodsSaleInfo> getGoodsSaleList(Integer id);
          public List<commentInfo> getStoreCommentList(Integer id);
}
