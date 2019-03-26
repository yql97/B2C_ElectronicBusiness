package shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_card")
public class bankCard {
    @Id
    private int  bank_card_id;
    @Column(name="bank_name")
    private String bank_name;
    @Column(name="bank_card_balance")
    private double bank_card_balance;
    @Column(name="owner_id")
    private String owner_id;
    @Column(name="bank_card_code")
    private String bank_card_code;
    @Column(name="account_id")
    private int  account_id;
    @Column(name="status")
    private int status;

    public int getBank_card_id() {
        return bank_card_id;
    }

    public void setBank_card_id(int bank_card_id) {
        this.bank_card_id = bank_card_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public double getBank_card_balance() {
        return bank_card_balance;
    }

    public void setBank_card_balance(double bank_card_balance) {
        this.bank_card_balance = bank_card_balance;
    }

    public String getBank_card_code() {
        return bank_card_code;
    }

    public void setBank_card_code(String bank_card_code) {
        this.bank_card_code = bank_card_code;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }
}
