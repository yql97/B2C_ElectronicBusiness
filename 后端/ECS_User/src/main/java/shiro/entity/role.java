package shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="role")
public class role {
    @Id
    private int role_id;
    @Column(name="role_name")
    private String rolename;
    @Column(name="role_description")
    private String roledescription;
    @Column(name="role_type_code")
    private int role_type_code;
    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledescription() {
        return roledescription;
    }

    public void setRoledescription(String roledescription) {
        this.roledescription = roledescription;
    }

    public int getRole_type_code() {
        return role_type_code;
    }

    public void setRole_type_code(int role_type_code) {
        this.role_type_code = role_type_code;
    }
}
