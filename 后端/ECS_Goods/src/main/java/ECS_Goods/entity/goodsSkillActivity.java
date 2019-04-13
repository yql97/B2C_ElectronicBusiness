/**
 * 
 */
package ECS_Goods.entity;

import java.util.Date;

/**
 * @author yueqiulin
 *
 */
public class goodsSkillActivity {
         private int id;
         private int goods_id;
         private Date start_time;
         private Date end_time;
         private int skill_count;
         
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getGoods_id() {
			return goods_id;
		}
		public void setGoods_id(int goods_id) {
			this.goods_id = goods_id;
		}
		public Date getStart_time() {
			return start_time;
		}
		public void setStart_time(Date start_time) {
			this.start_time = start_time;
		}
		public Date getEnd_time() {
			return end_time;
		}
		public void setEnd_time(Date end_time) {
			this.end_time = end_time;
		}
		public int getSkill_count() {
			return skill_count;
		}
		public void setSkill_count(int skill_count) {
			this.skill_count = skill_count;
		}
         
         
}
