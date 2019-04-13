/**
 * 
 */
package ECS_Goods.entity;

import java.util.Date;

/**
 * @author yueqiulin
 *
 */
public class skillGoodsInfo {
             private int skill_id;
             private int goods_id;
             private String goods_name;
             private String goods_main_image;
             private Date start_time;
             private Date end_time;
             private int skill_count;
             private double now_price;
             private double old_price;
			public int getSkill_id() {
				return skill_id;
			}
			public void setSkill_id(int skill_id) {
				this.skill_id = skill_id;
			}
			public int getGoods_id() {
				return goods_id;
			}
			public void setGoods_id(int goods_id) {
				this.goods_id = goods_id;
			}
			public String getGoods_name() {
				return goods_name;
			}
			public void setGoods_name(String goods_name) {
				this.goods_name = goods_name;
			}
			public String getGoods_main_image() {
				return goods_main_image;
			}
			public void setGoods_main_image(String goods_main_image) {
				this.goods_main_image = goods_main_image;
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
			public double getNow_price() {
				return now_price;
			}
			public void setNow_price(double now_price) {
				this.now_price = now_price;
			}
			public double getOld_price() {
				return old_price;
			}
			public void setOld_price(double old_price) {
				this.old_price = old_price;
			}
             
}
