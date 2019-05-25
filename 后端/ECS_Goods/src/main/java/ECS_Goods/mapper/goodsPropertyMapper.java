/**
 * 
 */
package ECS_Goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ECS_Common.entity.goodsPropertyName;
import ECS_Common.entity.goodsPropertyRelate;
import ECS_Common.entity.goodsPropertyValue;
import ECS_Goods.entity.goodsPropertyInfo;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface goodsPropertyMapper {
	 public List<goodsPropertyName> getPropertyNameList(Integer id);
	 public List<goodsPropertyValue> getPropertyValueList(Integer id);
     public goodsPropertyInfo getGoodsProperty(Integer id);
     public int	addGoodsProperty(goodsPropertyName gpn);
     public int addPropertyValue(goodsPropertyValue gpv);
     public int addPropertyRelate(goodsPropertyRelate gpr);
     public List<goodsPropertyInfo> getGoodsPropertyList(Integer id);
}
