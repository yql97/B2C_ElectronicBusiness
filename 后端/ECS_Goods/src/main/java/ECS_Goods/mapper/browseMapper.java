/**
 * 
 */
package ECS_Goods.mapper;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.browseRecord;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface browseMapper {
     public int addBrowseRecord(browseRecord br);
     public int deleteBrowseRecord(browseRecord br);
}
