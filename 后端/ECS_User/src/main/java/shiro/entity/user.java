/**
 * 
 */
package shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * @author yueqiulin
 *
 */
@Entity
@Table(name = "user")
public class user implements Serializable {
    private static final long serialVersionUID = 5610870819322977343L;
    @Id
    private int user_id;

 @Column(name = "username")
 private String username;
 @Column(name = "password")
 private String userpassword;
 @Column(name = "phone_num")
 private String  phonenumber;
 @Column(name = "email_num")
 private String mailnumber;
 @Column(name="pay_password")
 private int payPassword;
 @Column(name = "create_time")
 private Date createtime;
 @Column(name = "update_time")
 private Date updatetime;

    public int getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(int payPassword) {
        this.payPassword = payPassword;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMailnumber() {
        return mailnumber;
    }

    public void setMailnumber(String mailnumber) {
        this.mailnumber = mailnumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public user(String username, String userpassword) {
	 this.username=username;
     this.userpassword=userpassword;
 }
 public user(){

 }

    @Override
    public String toString() {
        return "user{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", mailnumber='" + mailnumber + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpassword() {
	return userpassword;
}
public void setUserpassword(String userpassword) {
	this.userpassword = userpassword;
}
}
