/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.favoritesRecord;
import ECS_Common.entity.store;
import ECS_Goods.entity.goodsBaseInfo;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface favoritesRecordMapper {
	   public int addFavoritesRecord(favoritesRecord fr);
	   public List<goodsBaseInfo> getFavoritesGoods(Integer id);
	   public List<store> getFavoritesStore(Integer id);
	   public int deleteFavorites();
}
