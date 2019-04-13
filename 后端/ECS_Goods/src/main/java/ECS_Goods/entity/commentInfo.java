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
            private Date create_time;
            private String username;
            private String comment_text;
            private String comment_image;
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
            
}
