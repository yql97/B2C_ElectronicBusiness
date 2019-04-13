/**
 * 
 */
package ECS_Goods.entity;

/**
 * @author yueqiulin
 *
 */
public class goodsSpu {
	private  String goods_name;
    private String goods_title;
    private Integer goods_family_id;
    private String  goods_category;
    
    
	@Override
	public String toString() {
		return "goodsSpu [goods_name=" + goods_name + ", goods_title=" + goods_title + ", goods_family_id="
				+ goods_family_id + ", goods_category=" + goods_category + "]";
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_title() {
		return goods_title;
	}
	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}
	public Integer getGoods_family_id() {
		return goods_family_id;
	}
	public void setGoods_family_id(Integer goods_family_id) {
		this.goods_family_id = goods_family_id;
	}
	public String getGoods_category() {
		return goods_category;
	}
	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}
    
}
