/**
 * 
 */
package ECS_Goods.entity;

import java.util.Date;

/**
 * @author yueqiulin
 *
 */
public class browseRecordInfo {
             private Date create_time;
             private int record_num;
             private int goods_id;
             private int goods_name;
             private String goods_main_image;
             private double now_price;
             private double old_price;
             
			public Date getCreate_time() {
				return create_time;
			}
			public void setCreate_time(Date create_time) {
				this.create_time = create_time;
			}
			public int getRecord_num() {
				return record_num;
			}
			public void setRecord_num(int record_num) {
				this.record_num = record_num;
			}
			public int getGoods_id() {
				return goods_id;
			}
			public void setGoods_id(int goods_id) {
				this.goods_id = goods_id;
			}
			public int getGoods_name() {
				return goods_name;
			}
			public void setGoods_name(int goods_name) {
				this.goods_name = goods_name;
			}
			public String getGoods_main_image() {
				return goods_main_image;
			}
			public void setGoods_main_image(String goods_main_image) {
				this.goods_main_image = goods_main_image;
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
