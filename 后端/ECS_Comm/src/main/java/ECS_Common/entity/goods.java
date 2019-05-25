 package ECS_Common.entity;

import java.util.Date;

import ECS_Common.util.dateTimeUtil;

/**
 * @author yueqiulin
 *
 */
public class goods {
    private int id;
    private String name;
    private String title;
    private int store_id;
    private int monthlySales;
    private int commentVolume;
    private int favoritesVolume;
    private int pageViews;
    private int totalSales;
    private int status;
    private int category_Id;
    private Date createTime;//上架时间
    private Date deleteTime;//下架时间
    private String goods_sku_id_list;
    
    
    public goods(int goods_id,String name, String title, int store_id, int category_Id,Date createTime) {
		super();
		this.id=goods_id;
		this.name = name;
		this.title = title;
		this.store_id = store_id;
		this.category_Id = category_Id;
		this.createTime =createTime;
	}
	public String getGoods_sku_id_list() {
		return goods_sku_id_list;
	}
	public void setGoods_sku_id_list(String goods_sku_id_list) {
		this.goods_sku_id_list = goods_sku_id_list;
	}
	private String main_image;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}
	public goods() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMonthlySales() {
		return monthlySales;
	}
	public void setMonthlySales(int monthlySales) {
		this.monthlySales = monthlySales;
	}
	public int getCommentVolume() {
		return commentVolume;
	}
	public void setCommentVolume(int commentVolume) {
		this.commentVolume = commentVolume;
	}
	public int getFavoritesVolume() {
		return favoritesVolume;
	}
	public void setFavoritesVolume(int favoritesVolume) {
		this.favoritesVolume = favoritesVolume;
	}
	public int getPageViews() {
		return pageViews;
	}
	public void setPageViews(int pageViews) {
		this.pageViews = pageViews;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMain_image() {
		return main_image;
	}
	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	@Override
	public String toString() {
		return "goods [id=" + id + ", name=" + name + ", title=" + title + ", store_id=" + store_id + ", monthlySales="
				+ monthlySales + ", commentVolume=" + commentVolume + ", favoritesVolume=" + favoritesVolume
				+ ", pageViews=" + pageViews + ", totalSales=" + totalSales + ", status=" + status + ", category_Id="
				+ category_Id + ", createTime=" + createTime + ", deleteTime=" + deleteTime+ ", goods_sku_id_list="
				+ goods_sku_id_list + ", main_image=" + main_image + "]";
	}
    
}
