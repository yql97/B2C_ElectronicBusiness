package main.java.shiro.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import main.java.shiro.dao.peopleCardDao;
import main.java.shiro.entity.peopleCard;
import main.java.shiro.util.hibernateSessionUtil;

import java.util.List;

@Repository
public class peopleCardImpl implements peopleCardDao {
    @Autowired
    private hibernateSessionUtil sessionUtil;

    public int addPeopleCard(peopleCard people_card) {
       Session session=sessionUtil.getSession1();
       Transaction tx =session.beginTransaction();
           session.save(people_card);
            tx.commit();
            session.close();
        return 1;
    }

    public int updatePeopleCard(peopleCard people_card) {

        Session session=sessionUtil.getSession1();
        Transaction tx =session.beginTransaction();
         session.update(people_card);
        tx.commit();
        session.close();
        return 1;

    }

    public peopleCard selectByUserId(int id) {
        Session session=sessionUtil.getSession1();
         Query q  =session.createQuery("from peopleCard where user_id=?");
         q.setInteger(0,id);
          List<peopleCard> plist=q.list();
          session.close();
          if(plist!=null) return  plist.get(0);
        return null;
    }
}
