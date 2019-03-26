package shiro.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shiro.dao.userDao;
import shiro.entity.user;
import shiro.util.hibernateSessionUtil;

import java.io.UnsupportedEncodingException;
import java.util.List;
@Repository
public class userImpl {
    @Autowired
    private hibernateSessionUtil sessionUtil;


    public List<user> getUser(){     //
       Session session=sessionUtil.getSession1();
        Query q  =session.createQuery("from user"); //HQL 映射的为类名 而不是表名
        List<user> ulist = q.list();
        session.close();
        return ulist;
    }
    public user getUserByName(String name){
        Session session=sessionUtil.getSession1();
        Query q=session.createQuery("from user where username =:username");
        q.setParameter("username",name);
        List<user>  ulist =q.list();
        session.close();
        System.out.print(ulist.toString());
        return ulist.get(0);
    }
    public user getUserById(int userid){
        Session session=sessionUtil.getSession1();
        Query q=session.createQuery("from user where user_id =?");
        q.setInteger(0,userid);
        List<user>  ulist =q.list();
        return ulist.get(0);
    }
    public int setUser(user u){
        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        session.save(u);
        tx.commit();
        session.close();
        return 1;
    }
    public int editUser(user u){
        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        session.update(u);
        tx.commit();
        session.close();
        return 1;
    }
}
