package ECS_Common.entity;
/**
 * @author yueqiulin
 *
 */
public class store {
    private int store_id;
    private String store_name;
    private String store_title;
    private int status;
    private int category_id;
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
	public String getStore_title() {
		return store_title;
	}
	public void setStore_title(String store_title) {
		this.store_title = store_title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	@Override
	public String toString() {
		return "store [store_id=" + store_id + ", store_name=" + store_name + ", store_title=" + store_title
				+ ", status=" + status + ", category_id=" + category_id + "]";
	}
    
}
