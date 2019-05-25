/**
 * 
 */
package ECS_Common.entity;

import java.util.Date;

/**
 * @author yueqiulin
 *
 */

public class order {
	private int id;
    private int user_id;
    private int order_code;
    private int goods_sku_id;
    private int status;
    private Date createTime;
    private int logistics_order_id;
    private int trade_id;
    private String buyer_message;
    private int receive_address_id;
    private int goods_num;
    
    
	public order(Integer id, Integer user_id, Integer order_code, Integer goods_sku_id, Integer status, Date createTime, Integer goods_num) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.order_code = order_code;
		this.goods_sku_id = goods_sku_id;
		this.status = status;
		this.createTime = createTime;
		this.goods_num = goods_num;
	}
	@Override
	public String toString() {
		return "order [id=" + id + ", user_id=" + user_id + ", order_code=" + order_code + ", goods_sku_id="
				+ goods_sku_id + ", status=" + status + ", createTime=" + createTime + ", logistics_order_id="
				+ logistics_order_id + ", trade_id=" + trade_id + ", buyer_message=" + buyer_message
				+ ", receive_address_id=" + receive_address_id + ", goods_num=" + goods_num + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrder_code() {
		return order_code;
	}
	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}
	public int getGoods_sku_id() {
		return goods_sku_id;
	}
	public void setGoods_sku_id(int goods_sku_id) {
		this.goods_sku_id = goods_sku_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getLogistics_order_id() {
		return logistics_order_id;
	}
	public void setLogistics_order_id(int logistics_order_id) {
		this.logistics_order_id = logistics_order_id;
	}
	public int getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(int trade_id) {
		this.trade_id = trade_id;
	}
	public String getBuyer_message() {
		return buyer_message;
	}
	public void setBuyer_message(String buyer_message) {
		this.buyer_message = buyer_message;
	}
	public int getReceive_address_id() {
		return receive_address_id;
	}
	public void setReceive_address_id(int receive_address_id) {
		this.receive_address_id = receive_address_id;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
    
    

    
}
