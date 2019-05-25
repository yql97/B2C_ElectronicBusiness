/**
 * 
 */
package ECS_Common.entity;

import java.util.Date;

/**
 * @author yueqiulin
 *
 */
public class goodsComment {
       private int id;
       private int user_id;
       private int goods_id;
       private String commentText;
       private String commentImage;
       private Date createTime;
       
       
	@Override
	public String toString() {
		return "goodsComment [id=" + id + ", user_id=" + user_id + ", goods_id=" + goods_id + ", commentText="
				+ commentText + ", commentImage=" + commentImage + ", createTime=" + createTime + "]";
	}
	public goodsComment() {
		super();
	}
	public goodsComment(int id, int user_id, int goods_id, String commentText, String commentImage, Date createTime) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.commentText = commentText;
		this.commentImage = commentImage;
		this.createTime = createTime;
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
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getCommentImage() {
		return commentImage;
	}
	public void setCommentImage(String commentImage) {
		this.commentImage = commentImage;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
       
}
