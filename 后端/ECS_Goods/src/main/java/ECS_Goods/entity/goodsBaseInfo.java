/**
 * 
 */
package ECS_Goods.entity;

/**
 * @author yueqiulin
 *
 */
public class goodsBaseInfo {
             private int goods_id;
             private String goods_name;
             private String goods_image;
             private double now_price;
             private double old_price;
             
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
			public String getGoods_image() {
				return goods_image;
			}
			public void setGoods_image(String goods_image) {
				this.goods_image = goods_image;
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
