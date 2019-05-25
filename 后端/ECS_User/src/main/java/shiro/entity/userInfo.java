package main.java.shiro.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="user_info")
public class userInfo {
    @Id
    private int user_info_id;
    @Column(name = "user_nickname")
    private String nickname;
    @Column(name = "real_name")
    private String realname;
    @Column(name = "gender")
    private int gender;
    @Column(name = "birth_date")
    private Date birthdate;
    @Column(name = "birth_address")
    private String birthaddress;
    @Column(name = "live_address")
    private String liveaddress;

    public int getUser_info_id() {
        return user_info_id;
    }

    public void setUser_info_id(int user_info_id) {
        this.user_info_id = user_info_id;
    }

    public String getLiveaddress() {
        return liveaddress;
    }
    public void setLiveaddress(String liveaddress) {
        this.liveaddress = liveaddress;
    }

    public String getBirthaddress() {
        return birthaddress;
    }

    public void setBirthaddress(String birthaddress) {
        this.birthaddress = birthaddress;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
