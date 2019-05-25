/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.browseRecord;
import ECS_Common.entity.store;
import ECS_Goods.entity.browseRecordInfo;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface browseMapper {
	 public List<browseRecordInfo> getUserBrowseGoods(Integer id );
     public int addBrowseRecord(browseRecord br);
     public int deleteBrowseRecord(browseRecord br);
}
