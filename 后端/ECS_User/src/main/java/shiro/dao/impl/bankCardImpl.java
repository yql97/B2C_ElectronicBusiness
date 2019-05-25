package main.java.shiro.dao.impl;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import main.java.shiro.dao.bankCardDao;
import main.java.shiro.entity.bankCard;
import main.java.shiro.util.hibernateSessionUtil;

import java.util.List;

@Repository
public class bankCardImpl implements bankCardDao {
    @Autowired
    private hibernateSessionUtil sessionUtil;

    public List<bankCard> selectByAccountId(int id) {
        Session session=sessionUtil.getSession1();
        Query q=session.createSQLQuery("select * from bank_card where account_id=?");
           q.setInteger(0,id);
          List<bankCard> blist =q.list();
          session.close();
          if(blist!=null&&blist.size()!=0) return blist;
        return null;
    }

    public bankCard selectById(String id) {
        Session session=sessionUtil.getSession1();
        Query q=session.createQuery("from bankCard where bank_card_code=?");
        q.setString(0,id);
        List<bankCard> bclist=q.list();
        session.close();
        if(bclist!=null) return bclist.get(0);
        return null;
    }

    public int addBankCard(bankCard bank_card) {

        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        session.save(bank_card);
        tx.commit();
        session.close();
        return 1;

    }

    public int addBankCardBalance(bankCard bank_card,double add_num) {
        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        bank_card.setBank_card_balance(bank_card.getBank_card_balance()+add_num);
       session.update(bank_card);
        tx.commit();
        session.close();
        return 1;
    }

    public int subBankCardBalance(bankCard bank_card,double sub_num){
        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        bank_card.setBank_card_balance(bank_card.getBank_card_balance()-sub_num);
        session.update(bank_card);
        tx.commit();
        session.close();
        return 1;
    }

    public int deleteBankCard(bankCard bank_card) {
        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        session.delete(bank_card);
        tx.commit();
        session.close();
        return 1;
    }
}
