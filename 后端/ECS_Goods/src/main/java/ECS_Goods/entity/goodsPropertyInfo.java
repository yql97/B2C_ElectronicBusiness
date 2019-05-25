/**
 * 
 */
package ECS_Goods.entity;

/**
 * @author yueqiulin
 *
 */
public class goodsPropertyInfo {
       private int goods_sku_id;
       private int goods_property_relate_id;
       private String goods_property_name;
       private String goods_property_value;
       
	@Override
	public String toString() {
		return "goodsPropertyInfo [goods_sku_id=" + goods_sku_id + ", goods_property_relate_id="
				+ goods_property_relate_id + ", goods_property_name=" + goods_property_name + ", goods_property_value="
				+ goods_property_value + "]";
	}
	
	public int getGoods_sku_id() {
		return goods_sku_id;
	}
	public void setGoods_sku_id(int goods_sku_id) {
		this.goods_sku_id = goods_sku_id;
	}
	public int getGoods_property_relate_id() {
		return goods_property_relate_id;
	}
	public void setGoods_property_relate_id(int goods_property_relate_id) {
		this.goods_property_relate_id = goods_property_relate_id;
	}
	public String getGoods_property_name() {
		return goods_property_name;
	}
	public void setGoods_property_name(String goods_property_name) {
		this.goods_property_name = goods_property_name;
	}
	public String getGoods_property_value() {
		return goods_property_value;
	}
	public void setGoods_property_value(String goods_property_value) {
		this.goods_property_value = goods_property_value;
	}
       
}
