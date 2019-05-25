package main.java.shiro.entity;

import org.hibernate.annotations.Entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trade")
public class tradeRecord {
    @Id
    private int trade_id;
    @Column(name="order_id")
    private int order_id;
    @Column(name="payer_account_id")
    private int payer_account_id;
    @Column(name="receiver_account_id")
    private int receiver_account_id;
    @Column(name="trade_num")
    private int trade_num;
    @Column(name="create_time")
    private Date create_time;

    public int getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(int trade_id) {
        this.trade_id = trade_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getPayer_account_id() {
        return payer_account_id;
    }

    public void setPayer_account_id(int payer_account_id) {
        this.payer_account_id = payer_account_id;
    }

    public int getReceiver_account_id() {
        return receiver_account_id;
    }

    public void setReceiver_account_id(int receiver_account_id) {
        this.receiver_account_id = receiver_account_id;
    }

    public int getTrade_num() {
        return trade_num;
    }

    public void setTrade_num(int trade_num) {
        this.trade_num = trade_num;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
