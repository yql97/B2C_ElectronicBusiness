package shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class account {
    @Id
    private int account_id;
    @Column(name="account_balance")
    private double balance;
    @Column(name="bank_card_num")
    private int bankCard_num;
    @Column(name="account_code")
    private String accountCode;
    @Column(name="status")
    private int status;
    @Column(name="user_id")
    private int user_id;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getBankCard_num() {
        return bankCard_num;
    }

    public void setBankCard_num(int bankCard_num) {
        this.bankCard_num = bankCard_num;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
