/**
 * 
 */
package ECS_Common.entity;

/**
 * @author yueqiulin
 *
 */
public class goodsPropertyRelate {
       private int goods_sku_id;
       private int propertyRelate_id;
       private int propertyName_id;
       private int propertyValue_id;
       

	public goodsPropertyRelate(int goods_sku_id, int propertyName_id, int propertyValue_id) {
		super();
		this.goods_sku_id = goods_sku_id;
		this.propertyName_id = propertyName_id;
		this.propertyValue_id = propertyValue_id;
	}
	public int getGoods_sku_id() {
		return goods_sku_id;
	}
	public void setGoods_sku_id(int goods_sku_id) {
		this.goods_sku_id = goods_sku_id;
	}
	public int getPropertyRelate_id() {
		return propertyRelate_id;
	}
	public void setPropertyRelate_id(int propertyRelate_id) {
		this.propertyRelate_id = propertyRelate_id;
	}
	public int getPropertyName_id() {
		return propertyName_id;
	}
	public void setPropertyName_id(int propertyName_id) {
		this.propertyName_id = propertyName_id;
	}
	public int getPropertyValue_id() {
		return propertyValue_id;
	}
	public void setPropertyValue_id(int propertyValue_id) {
		this.propertyValue_id = propertyValue_id;
	}
       
       
}
