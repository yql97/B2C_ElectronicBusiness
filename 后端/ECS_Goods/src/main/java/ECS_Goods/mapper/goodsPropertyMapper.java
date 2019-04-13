/**
 * 
 */
package ECS_Goods.mapper;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.goodsPropertyName;
import ECS_Common.entity.goodsPropertyRelate;
import ECS_Common.entity.goodsPropertyValue;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface goodsPropertyMapper {
     public int	addGoodsProperty(goodsPropertyName gpn);
     public int addPropertyValue(goodsPropertyValue gpv);
     public int addPropertyRelate(goodsPropertyRelate gpr);
}
