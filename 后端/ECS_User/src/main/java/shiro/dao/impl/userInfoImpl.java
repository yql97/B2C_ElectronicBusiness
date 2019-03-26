package shiro.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shiro.dao.userInfoDao;
import shiro.entity.user;
import shiro.entity.userInfo;
import shiro.util.hibernateSessionUtil;

import java.util.List;

@Repository
public class userInfoImpl implements userInfoDao {
    @Autowired
    private hibernateSessionUtil sessionUtil;

    public int editUserBaseInfo(userInfo u) {
        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        session.update(u);
        tx.commit();
        session.close();
        return 1;
    }

    public int addUserBaseInfo(userInfo u) {
        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
        session.save(u);
        tx.commit();
        session.close();
        return 1;
    }

    public userInfo getUserBaseInfo(int userid) {
       Session session=sessionUtil.getSession1();
       Query q=session.createSQLQuery("select * from user_info where user_id=?");
       q.setInteger(0,userid);
       List<userInfo> ulist=q.list();
       session.close();
       if(ulist.size()>0) return ulist.get(0);
        return null;
    }
}
