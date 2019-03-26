package shiro.dao.impl;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shiro.dao.accountDao;
import shiro.entity.account;
import shiro.util.hibernateSessionUtil;
import org.hibernate.Session;

import java.util.List;

@Repository
public class accountImpl implements accountDao {
    @Autowired
    private hibernateSessionUtil sessionUtil;

    public account selectByUserId(int id) {

          Session session=sessionUtil.getSession1();
           Query q=session.createQuery("from account where user_id=?");
                q.setInteger(0,id);
               List<account> alist=q.list();
               session.close();
               if(alist!=null) return  alist.get(0);
        return null;
    }

    public account selectById(String id) {
        Session session=sessionUtil.getSession1();
        Query q = session.createQuery("from account where account_code=?");
        q.setString(0,id);
        List<account> alist=q.list();
        session.close();
        System.out.print(alist.size());
        if(alist.size()>0) return alist.get(0);
        return null;
    }

    public int addAccount(account account) {

        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        session.save(account);
        tx.commit();
        session.close();
        return 1;
    }

    public int addAccountBalance(account account,double add_number) {
        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        account.setBalance(account.getBalance()+add_number);
         session.update(account);
         tx.commit();
         session.close();
        return 1;
    }

    public int subAccountBalance(account account,double sub_number) {
        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        account.setBalance(account.getBalance()-sub_number);
        session.update(account);
        tx.commit();
        session.close();
        return 1;
    }

    public int addAccountBankCardNum(account account){
        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        account.setBankCard_num(account.getBankCard_num()+1);
        session.update(account);
        tx.commit();
        session.close();
        return 1;
    }

    public int subAccountBankCardNum(account account){
        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        account.setBankCard_num(account.getBankCard_num()-1);
        session.update(account);
        tx.commit();
        session.close();
        return 1;
    }

    public int deleteAccountBalance(account account) {
        return 0;
    }

}
