/**
 * 
 */
package ECS_Goods.mapper;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.favoritesRecord;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface favoritesRecordMapper {
	   public int addFavoritesRecord(favoritesRecord fr);
}
