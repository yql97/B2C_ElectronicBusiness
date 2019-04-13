/**
 * 
 */
package ECS_Goods.entity;

/**
 * @author yueqiulin
 *
 */
public class storeGoodsInfo {
             private Integer goods_id;
             private Integer goods_sku_id;
             private String goods_name;
             private String image_url;
             private double old_price;
             private double new_price;
             private Integer stroage_balance;
             private Integer status;
             
             
			@Override
			public String toString() {
				return "storeGoodsInfo [goods_id=" + goods_id + ", goods_sku_id=" + goods_sku_id + ", goods_name="
						+ goods_name + ", image_url=" + image_url + ", old_price=" + old_price + ", new_price="
						+ new_price + ", stroage_balance=" + stroage_balance + ", status=" + status + "]";
			}
			public Integer getGoods_id() {
				return goods_id;
			}
			public void setGoods_id(Integer goods_id) {
				this.goods_id = goods_id;
			}
			public Integer getGoods_sku_id() {
				return goods_sku_id;
			}
			public void setGoods_sku_id(Integer goods_sku_id) {
				this.goods_sku_id = goods_sku_id;
			}
			public String getGoods_name() {
				return goods_name;
			}
			public void setGoods_name(String goods_name) {
				this.goods_name = goods_name;
			}
			public String getImage_url() {
				return image_url;
			}
			public void setImage_url(String image_url) {
				this.image_url = image_url;
			}
			public double getOld_price() {
				return old_price;
			}
			public void setOld_price(double old_price) {
				this.old_price = old_price;
			}
			public double getNew_price() {
				return new_price;
			}
			public void setNew_price(double new_price) {
				this.new_price = new_price;
			}
			public Integer getStroage_balance() {
				return stroage_balance;
			}
			public void setStroage_balance(Integer stroage_balance) {
				this.stroage_balance = stroage_balance;
			}
			public Integer getStatus() {
				return status;
			}
			public void setStatus(Integer status) {
				this.status = status;
			}
             
}
