/**
 * 
 */
package ECS_Goods.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ECS_Goods.entity.goodsSkillActivity;

/**
 * @author yueqiulin
 *
 */
@Mapper
public interface goodsSkillMapper {
	   public int addGoodsSkillActivity(goodsSkillActivity gsa);
	   public List<goodsSkillActivity> getSkillGoods(Date start,Date end);
}
