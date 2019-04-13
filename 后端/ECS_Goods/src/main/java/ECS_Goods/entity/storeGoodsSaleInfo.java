/**
 * 
 */
package ECS_Goods.entity;

/**
 * @author yueqiulin
 *
 */
public class storeGoodsSaleInfo {
             private String goods_name;
             private Integer favorites_volume;
             private Integer monthly_sales;
             private Integer stroage_balance;
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
			public Integer getMonthly_sales() {
				return monthly_sales;
			}
			public void setMonthly_sales(Integer monthly_sales) {
				this.monthly_sales = monthly_sales;
			}
			public Integer getStroage_balance() {
				return stroage_balance;
			}
			public void setStroage_balance(Integer stroage_balance) {
				this.stroage_balance = stroage_balance;
			}
             
}
