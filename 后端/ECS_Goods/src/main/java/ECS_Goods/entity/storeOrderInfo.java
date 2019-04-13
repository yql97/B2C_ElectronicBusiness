/**
 * 
 */
package ECS_Goods.entity;

import java.util.Date;

/**
 * @author yueqiulin
 *
 */
public class storeOrderInfo {
	         private Integer order_id;
	         private Integer goods_sku_id;
	         private Date create_time;
             private Integer order_code;
             private String goods_name;
             private double price;
             private Integer buy_num;
             private Integer receive_address_id;
             private Integer status;
			public Integer getOrder_id() {
				return order_id;
			}
			public void setOrder_id(Integer order_id) {
				this.order_id = order_id;
			}
			public Date getCreate_time() {
				return create_time;
			}
			public void setCreate_time(Date create_time) {
				this.create_time = create_time;
			}
			public Integer getOrder_code() {
				return order_code;
			}
			public void setOrder_code(Integer order_code) {
				this.order_code = order_code;
			}
			public String getGoods_name() {
				return goods_name;
			}
			public void setGoods_name(String goods_name) {
				this.goods_name = goods_name;
			}
			public double getPrice() {
				return price;
			}
			public void setPrice(double price) {
				this.price = price;
			}
			public Integer getBuy_num() {
				return buy_num;
			}
			public void setBuy_num(Integer buy_num) {
				this.buy_num = buy_num;
			}
			public Integer getStatus() {
				return status;
			}
			public void setStatus(Integer status) {
				this.status = status;
			}
			public Integer getGoods_sku_id() {
				return goods_sku_id;
			}
			public void setGoods_sku_id(Integer goods_sku_id) {
				this.goods_sku_id = goods_sku_id;
			}
			public Integer getReceive_address_id() {
				return receive_address_id;
			}
			public void setReceive_address_id(Integer receive_address_id) {
				this.receive_address_id = receive_address_id;
			}
             
}
