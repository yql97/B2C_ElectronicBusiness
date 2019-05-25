package main.java.shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name="user_login_record")
public class userLoginRecord {
    @Id
    private int user_login_record_id;
    @Column(name="login_time")
    private Date login_date;
    @Column(name="login_position")
    private String login_position;
    @Column(name="login_ip")
    private String login_ip;
    @Column(name="user_id")
    private int user_id;
    @Column(name="status")
    private int status;

    public int getUser_login_record_id() {
        return user_login_record_id;
    }

    public void setUser_login_record_id(int user_login_record_id) {
        this.user_login_record_id = user_login_record_id;
    }

    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }

    public String getLogin_position() {
        return login_position;
    }

    public void setLogin_position(String login_position) {
        this.login_position = login_position;
    }

    public String getLogin_ip() {
        return login_ip;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
