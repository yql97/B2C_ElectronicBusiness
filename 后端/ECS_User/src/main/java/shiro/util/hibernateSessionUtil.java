package main.java.shiro.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class hibernateSessionUtil {
    @Autowired
    private  SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){return sessionFactory;};
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    public Session getSession1(){
        return sessionFactory.openSession();
    }
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
