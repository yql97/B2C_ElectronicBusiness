/**
 * 
 */
package ECS_Goods.entity;

/**
 * @author yueqiulin
 *
 */
public class shopCartBaseInfo {
	private int shopCart_id;
	private int goods_sku_id;
	private int store_id;
	private String store_name;
	private String goods_main_image;
	private String goods_name;
	private double goods_old_price;
	private double goods_now_price;
	private int goods_num;
	
	public int getShopCart_id() {
		return shopCart_id;
	}
	public void setShopCart_id(int shopCart_id) {
		this.shopCart_id = shopCart_id;
	}
	public int getGoods_sku_id() {
		return goods_sku_id;
	}
	public void setGoods_sku_id(int goods_sku_id) {
		this.goods_sku_id = goods_sku_id;
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
	public String getGoods_main_image() {
		return goods_main_image;
	}
	public void setGoods_main_image(String goods_main_image) {
		this.goods_main_image = goods_main_image;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getGoods_old_price() {
		return goods_old_price;
	}
	public void setGoods_old_price(double goods_old_price) {
		this.goods_old_price = goods_old_price;
	}
	public double getGoods_now_price() {
		return goods_now_price;
	}
	public void setGoods_now_price(double goods_now_price) {
		this.goods_now_price = goods_now_price;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	
	

}
