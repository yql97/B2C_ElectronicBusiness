/**
 * 
 */
package ECS_Common.entity;

import java.util.Date;

/**
 * @author yueqiulin
 *
 */
public class goods_sku {
     private int id;
     private String name;
     private int goods_id;
     private double now_price;
     private double old_price;
     private int stroageBalance;
     private int stroageSaleVolume;
     private Date createTime;

	public goods_sku() {
		super();
	}
	public goods_sku(int id, String name, int goods_id, double now_price, double old_price, int stroageBalance,
			int stroageSaleVolume,Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.goods_id = goods_id;
		this.now_price = now_price;
		this.old_price = old_price;
		this.stroageBalance = stroageBalance;
		this.stroageSaleVolume = stroageSaleVolume;
		this.createTime=createTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public double getNow_price() {
		return now_price;
	}
	public void setNow_price(double now_price) {
		this.now_price = now_price;
	}
	public double getOld_price() {
		return old_price;
	}
	public void setOld_price(double old_price) {
		this.old_price = old_price;
	}
	public int getStroageBalance() {
		return stroageBalance;
	}
	public void setStroageBalance(int stroageBalance) {
		this.stroageBalance = stroageBalance;
	}
	public int getStroageSaleVolume() {
		return stroageSaleVolume;
	}
	public void setStroageSaleVolume(int stroageSaleVolume) {
		this.stroageSaleVolume = stroageSaleVolume;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "goods_sku [id=" + id + ", name=" + name + ", goods_id=" + goods_id + ", now_price=" + now_price
				+ ", old_price=" + old_price + ", stroageBalance=" + stroageBalance + ", stroageSaleVolume="
				+ stroageSaleVolume + ", createTime=" + createTime + "]";
	}
     
}
