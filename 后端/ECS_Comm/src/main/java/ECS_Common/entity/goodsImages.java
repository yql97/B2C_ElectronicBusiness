/**
 * 
 */
package ECS_Common.entity;

/**
 * @author yueqiulin
 *
 */
public class goodsImages {
    private int id;
    private int goods_sku_id;
    private String image_path;
    private int image_type;
    
    
	public goodsImages(int goods_sku_id, String image_path, int image_type) {
		super();
		this.goods_sku_id = goods_sku_id;
		this.image_path = image_path;
		this.image_type = image_type;
	}
	public goodsImages(int id,int goods_sku_id, String image_path, int image_type) {
		super();
		this.id=id;
		this.goods_sku_id = goods_sku_id;
		this.image_path = image_path;
		this.image_type = image_type;
	}
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
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public int getImage_type() {
		return image_type;
	}
	public void setImage_type(int image_type) {
		this.image_type = image_type;
	}
    
}
