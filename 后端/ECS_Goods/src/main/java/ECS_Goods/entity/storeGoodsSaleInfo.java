/**
 * 
 */
package ECS_Goods.entity;

/**
 * @author yueqiulin
 *
 */
public class storeGoodsSaleInfo {
	         private Integer goods_sku_id;
	         private double now_price;
             private String goods_name;
             private Integer favorites_volume;
             private Integer stroage_sales;
             private Integer stroage_balance;
             
           
			@Override
			public String toString() {
				return "storeGoodsSaleInfo [goods_sku_id=" + goods_sku_id + ", now_price=" + now_price + ", goods_name="
						+ goods_name + ", favorites_volume=" + favorites_volume + ", stroage_sales=" + stroage_sales
						+ ", stroage_balance=" + stroage_balance + "]";
			}
			public Integer getGoods_sku_id() {
				return goods_sku_id;
			}
			public void setGoods_sku_id(Integer goods_sku_id) {
				this.goods_sku_id = goods_sku_id;
			}
			public double getNow_price() {
				return now_price;
			}
			public void setNow_price(double now_price) {
				this.now_price = now_price;
			}
			public Integer getStroage_sales() {
				return stroage_sales;
			}
			public void setStroage_sales(Integer stroage_sales) {
				this.stroage_sales = stroage_sales;
			}
			public String getGoods_name() {
				return goods_name;
			}
			public void setGoods_name(String goods_name) {
				this.goods_name = goods_name;
			}
			public Integer getFavorites_volume() {
				return favorites_volume;
			}
			public void setFavorites_volume(Integer favorites_volume) {
				this.favorites_volume = favorites_volume;
			}
			public Integer getStroage_balance() {
				return stroage_balance;
			}
			public void setStroage_balance(Integer stroage_balance) {
				this.stroage_balance = stroage_balance;
			}
             
}
