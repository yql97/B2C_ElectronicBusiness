/**
 * 
 */
package ECS_Goods.entity;

import java.util.Date;

/**
 * @author yueqiulin
 *
 */
public class commentInfo {
	        private Integer comment_id;
            private Date create_time;
            private Integer goods_id;
            private String goods_name;
            private String username;
            private String comment_text;
            private String comment_image;
            
         
			@Override
			public String toString() {
				return "commentInfo [comment_id=" + comment_id + ", create_time=" + create_time + ", goods_id="
						+ goods_id + ", goods_name=" + goods_name + ", username=" + username + ", comment_text="
						+ comment_text + ", comment_image=" + comment_image + "]";
			}
			public Date getCreate_time() {
				return create_time;
			}
			public void setCreate_time(Date create_time) {
				this.create_time = create_time;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getComment_text() {
				return comment_text;
			}
			public void setComment_text(String comment_text) {
				this.comment_text = comment_text;
			}
			public String getComment_image() {
				return comment_image;
			}
			public void setComment_image(String comment_image) {
				this.comment_image = comment_image;
			}
			public Integer getComment_id() {
				return comment_id;
			}
			public void setComment_id(Integer comment_id) {
				this.comment_id = comment_id;
			}
			public Integer getGoods_id() {
				return goods_id;
			}
			public void setGoods_id(Integer goods_id) {
				this.goods_id = goods_id;
			}
			public String getGoods_name() {
				return goods_name;
			}
			public void setGoods_name(String goods_name) {
				this.goods_name = goods_name;
			}
            
}
