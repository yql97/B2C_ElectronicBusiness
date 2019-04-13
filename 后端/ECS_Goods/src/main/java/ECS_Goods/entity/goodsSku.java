/**
 * 
 */
package ECS_Goods.entity;

/**
 * @author yueqiulin
 *
 */
//商品入库单
public class goodsSku { 
	       private Integer goods_id;
           private double goods_price;
           private Integer goods_sku_num;
           private String propertyNameValue_list; //[id_valueid,15344_32,]
           private String add_property_list; //[name_value,内存_32G,]
         
           
		@Override
		public String toString() {
			return "goodsSku [goods_id=" + goods_id + ", goods_price=" + goods_price + ", goods_sku_num="
					+ goods_sku_num + ", propertyNameValue_list=" + propertyNameValue_list + ", add_property_list="
					+ add_property_list + "]";
		}
		public Integer getGoods_id() {
			return goods_id;
		}
		public void setGoods_id(Integer goods_id) {
			this.goods_id = goods_id;
		}
		public double getGoods_price() {
			return goods_price;
		}
		public void setGoods_price(double goods_price) {
			this.goods_price = goods_price;
		}
		public Integer getGoods_sku_num() {
			return goods_sku_num;
		}
		public void setGoods_sku_num(Integer goods_sku_num) {
			this.goods_sku_num = goods_sku_num;
		}
		public String getAdd_property_list() {
			return add_property_list;
		}
		public void setAdd_property_list(String add_property_list) {
			this.add_property_list = add_property_list;
		}
		public String getPropertyNameValue_list() {
			return propertyNameValue_list;
		}
		public void setPropertyNameValue_list(String propertyNameValue_list) {
			this.propertyNameValue_list = propertyNameValue_list;
		}
           
}
