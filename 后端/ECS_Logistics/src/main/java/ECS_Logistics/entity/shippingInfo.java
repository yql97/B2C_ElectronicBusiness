/**
 * 
 */
package ECS_Logistics.entity;

/**
 * @author yueqiulin
 *
 */
public class shippingInfo { //发货信息
	  private int id;
	  private String shipper_name;
	  private String shipping_address;
	  private String shipper_phone;
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShipper_name() {
		return shipper_name;
	}
	public void setShipper_name(String shipper_name) {
		this.shipper_name = shipper_name;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public String getShipper_phone() {
		return shipper_phone;
	}
	public void setShipper_phone(String shipper_phone) {
		this.shipper_phone = shipper_phone;
	}
	 
}
