/**
 * 
 */
package ECS_Common.entity;

/**
 * @author yueqiulin
 *
 */
public class goodsPropertyValue {
    private int propertyValue_id;
    private String propertyValue_text;
    private int propertyName_id;
    
    
    
	public goodsPropertyValue(int propertyValue_id,String propertyValue_text, int propertyName_id) {
		super();
		this.propertyValue_id = propertyValue_id;
		this.propertyValue_text = propertyValue_text;
		this.propertyName_id = propertyName_id;
	}
	public goodsPropertyValue( int propertyName_id,int propertyValue_id,String propertyValue_text) {
		super();
		this.propertyValue_id = propertyValue_id;
		this.propertyValue_text = propertyValue_text;
		this.propertyName_id = propertyName_id;
	}
	
	public int getPropertyValue_id() {
		return propertyValue_id;
	}
	public void setPropertyValue_id(int propertyValue_id) {
		this.propertyValue_id = propertyValue_id;
	}
	public String getPropertyValue_text() {
		return propertyValue_text;
	}
	public void setPropertyValue_text(String propertyValue_text) {
		this.propertyValue_text = propertyValue_text;
	}
	public int getPropertyName_id() {
		return propertyName_id;
	}
	public void setPropertyName_id(int propertyName_id) {
		this.propertyName_id = propertyName_id;
	}
    
}
