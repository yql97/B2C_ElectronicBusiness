package main.java.shiro.util;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class MySessionDao extends AbstractSessionDAO {

    @Autowired
    private RedisUtils redisUtils;
    private Map<Serializable,Session> map = new HashMap<Serializable,Session>();

    //删除session
    @Override
    public void delete(Session session) {
        if(session == null || session.getId() == null){
            System.out.println("Session is null");
            return;
        }
        redisUtils.remove(session.getId().toString());
    }

    public Collection<Session> getActiveSessions() {
        return null;
    }

    // 更新session
    @Override
    public void update(Session session) throws UnknownSessionException {
        if(session == null || session.getId() == null){
            System.out.println("Session is null");
            return;
        }
        Serializable sessionId = session.getId();
        redisUtils.set(sessionId.toString(), session);
    }
    // 创建session，保存到数据库
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        //添加进redis
        redisUtils.set(sessionId.toString(), session);
        return sessionId;
    }
    //获取session
    @Override
    protected Session doReadSession(Serializable sessionId) {
        return (Session) redisUtils.get(sessionId.toString());
    }
}
