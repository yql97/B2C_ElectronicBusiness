/**
 * 
 */
package ECS_Logistics.entity;

/**
 * @author yueqiulin
 *
 */
public class logisticsOrder {
       private int id;
       private String commpany_name;
       private int order_id;
       private int shipping_info_id; //发货信息
       private int logistics_order_code;
       
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommpany_name() {
		return commpany_name;
	}
	public void setCommpany_name(String commpany_name) {
		this.commpany_name = commpany_name;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getLogistics_order_code() {
		return logistics_order_code;
	}
	public void setLogistics_order_code(int logistics_order_code) {
		this.logistics_order_code = logistics_order_code;
	}
	public int getShipping_info_id() {
		return shipping_info_id;
	}
	public void setShipping_info_id(int shipping_info_id) {
		this.shipping_info_id = shipping_info_id;
	}
       
}
