package main.java.shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="receiving_address")
public class receivingAddress {
    @Id
    private int receiving_address_id;
    @Column(name="district")
    private String district;//地区
    @Column(name="receiver_name")
    private String receiverName;
    @Column(name="detailed_address")
    private String detailedAddress;//详细地址
    @Column(name="post_code")
    private int postCode;//邮编
    @Column(name="receiver_phone")
    private String receiverPhone;
    @Column(name="user_id")
    private int user_id;
    @Column(name="is_default")
    private int is_default;

    public int getReceiving_address_id() {
        return receiving_address_id;
    }

    public void setReceiving_address_id(int receiving_address_id) {
        this.receiving_address_id = receiving_address_id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
}
