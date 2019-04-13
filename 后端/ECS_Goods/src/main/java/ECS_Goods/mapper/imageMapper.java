/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.goodsImages;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface imageMapper {
       public int addImages(goodsImages image);
       public List<goodsImages> selectImages(Integer goods_id);
       public goodsImages  getImage(Integer id);
       public int deleteImages(Integer id);
}
