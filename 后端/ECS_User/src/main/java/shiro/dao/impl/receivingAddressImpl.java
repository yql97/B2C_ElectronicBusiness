package shiro.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shiro.dao.receivingAddressDao;
import shiro.entity.receivingAddress;
import shiro.util.hibernateSessionUtil;

import java.util.List;
@Repository
public class receivingAddressImpl implements receivingAddressDao {
    @Autowired
    private hibernateSessionUtil sessionUtil;

    public List<receivingAddress> selectByUserId(int id) {
        Session session=sessionUtil.getSession1();
        Query q=session.createQuery("from receivingAddress where user_id=?");
        q.setInteger(0,id);
        List<receivingAddress> rlist=q.list();
        session.close();
        if(rlist!=null&&rlist.size()>0) return rlist;
        return null;
    }
    public receivingAddress selectById(int id) {
        Session session=sessionUtil.getSession1();
        Query q=session.createQuery("from receivingAddress where receiving_address_id=?");
        q.setInteger(0,id);
        List<receivingAddress> rlist=q.list();
        session.close();
        if(rlist!=null&&rlist.size()>0) return rlist.get(0);
        return null;
    }
    public int addReceivingAddress(receivingAddress receiving_address) {
        Session session=sessionUtil.getSession1();
        Transaction tx=session.beginTransaction();
        session.save(receiving_address);
        tx.commit();
        session.close();
        return 1;
    }

    public int updateReceivingAddress(receivingAddress receiving_address) {
        Session session=sessionUtil.getSession1();
        Transaction tx=session.beginTransaction();
       session.update(receiving_address);
        tx.commit();
        session.close();
        return 1;
    }
    public int deleteReceivingAddress(receivingAddress receiving_address) {
        Session session=sessionUtil.getSession1();
        Transaction tx=session.beginTransaction();
        session.delete(receiving_address);
        tx.commit();
        session.close();
        return 1;
    }
    public int setIsDefaultReceivingAddress(int userid,receivingAddress receiving_address){
        Session session=sessionUtil.getSession1();
        Query q=session.createSQLQuery("select * from receiving_address where is_default=1 and user_id =?");
        q.setInteger(0,userid);
        List<receivingAddress> rlist=q.list();
        receivingAddress old_receive_address=rlist.get(0);
        Transaction tx=session.beginTransaction();
        old_receive_address.setIs_default(0);
        session.update(old_receive_address);
        receiving_address.setIs_default(1);
        session.update(receiving_address);
        tx.commit();
        session.close();
        return 1;
    }
}
