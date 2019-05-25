/**
 * 
 */
package ECS_Common.entity;

/**
 * @author yueqiulin
 *
 */
public class shopCart {
       private int id;
       private int goods_sku_id;
       private int goods_num;
       private int user_id;
       
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoods_sku_id() {
		return goods_sku_id;
	}
	public void setGoods_sku_id(int goods_sku_id) {
		this.goods_sku_id = goods_sku_id;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
       
}
