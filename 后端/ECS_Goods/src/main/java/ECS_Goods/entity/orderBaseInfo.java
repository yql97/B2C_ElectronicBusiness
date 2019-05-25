/**
 * 
 */
package ECS_Goods.entity;

import java.util.Date;

/**
 * @author yueqiulin
 *
 */
public class orderBaseInfo {
       private Date create_time;
       private int order_status;
       private int order_code;
       private int store_id;
       private String store_name;
       private int goods_id;
       private int goods_sku_id;
       private String goods_image_path;
       private String goods_name;
       private double old_price;
       private double new_price;
       private int goods_num;
       private int logistics_id;
       
       
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public int getOrder_code() {
		return order_code;
	}
	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getGoods_sku_id() {
		return goods_sku_id;
	}
	public void setGoods_sku_id(int goods_sku_id) {
		this.goods_sku_id = goods_sku_id;
	}
	
	public String getGoods_image_path() {
		return goods_image_path;
	}
	public void setGoods_image_path(String goods_image_path) {
		this.goods_image_path = goods_image_path;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getOld_price() {
		return old_price;
	}
	public void setOld_price(double old_price) {
		this.old_price = old_price;
	}
	public double getNew_price() {
		return new_price;
	}
	public void setNew_price(double new_price) {
		this.new_price = new_price;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public int getLogistics_id() {
		return logistics_id;
	}
	public void setLogistics_id(int logistics_id) {
		this.logistics_id = logistics_id;
	}
	@Override
	public String toString() {
		return "orderBaseInfo [create_time=" + create_time + ", order_status=" + order_status + ", order_code="
				+ order_code + ", store_id=" + store_id + ", store_name=" + store_name + ", goods_id=" + goods_id
				+ ", goods_sku_id=" + goods_sku_id + ", main_image=" + goods_image_path + ", goods_name=" + goods_name
				+ ", old_price=" + old_price + ", new_price=" + new_price + ", goods_num=" + goods_num
				+ ", logistics_id=" + logistics_id + "]";
	}
       
}
