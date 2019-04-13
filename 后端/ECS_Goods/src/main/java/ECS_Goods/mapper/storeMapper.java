/**
 * 
 */
package ECS_Goods.mapper;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.store;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface storeMapper {
          public store getStoreInfo(Integer store_id);
          public int addStore(store s);
}
