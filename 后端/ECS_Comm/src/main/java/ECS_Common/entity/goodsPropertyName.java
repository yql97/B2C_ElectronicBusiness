/**
 * 
 */
package ECS_Common.entity;

/**
 * @author yueqiulin
 *
 */
public class goodsPropertyName {
	
    private int propertyName_id;
    private int goodsCategory_id;
    private String propertyName_text;
    
    
    
	public goodsPropertyName(int propertyName_id, int goodsCategory_id, String propertyName_text) {
		super();
		this.propertyName_id=propertyName_id;
		this.goodsCategory_id = goodsCategory_id;
		this.propertyName_text = propertyName_text;
	}
	public goodsPropertyName( String propertyName_text,int propertyName_id, int goodsCategory_id) {
		super();
		this.propertyName_id=propertyName_id;
		this.goodsCategory_id = goodsCategory_id;
		this.propertyName_text = propertyName_text;
	}
	public int getPropertyName_id() {
		return propertyName_id;
	}
	public void setPropertyName_id(int propertyName_id) {
		this.propertyName_id = propertyName_id;
	}
	public int getGoodsCategory_id() {
		return goodsCategory_id;
	}
	public void setGoodsCategory_id(int goodsCategory_id) {
		this.goodsCategory_id = goodsCategory_id;
	}
	public String getPropertyName_text() {
		return propertyName_text;
	}
	public void setPropertyName_text(String propertyName_text) {
		this.propertyName_text = propertyName_text;
	}
    
}
