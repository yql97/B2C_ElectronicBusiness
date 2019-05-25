package main.java.shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "permission")
public class permission implements Serializable {
    private static final long serialVersionUID = 7551932388239286000L;
    @Id
    private int permission_id ;
    @Column(name="token")
    private String token;
    @Column(name="permission_description")
    private String permission_description;
    @Column(name="role_id")
    private int  role_id;

    public permission(){ }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPermission_description() {
        return permission_description;
    }

    public void setPermission_description(String permission_description) {
        this.permission_description = permission_description;
    }

}
