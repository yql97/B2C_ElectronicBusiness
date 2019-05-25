package main.java.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiro.dao.impl.userImpl;
import shiro.dao.impl.userInfoImpl;
import shiro.entity.user;
import shiro.entity.userInfo;

import java.util.List;
@Service
public class userService {

    @Autowired
    private userImpl userimpl;

    @Autowired
    private userInfoImpl uii;

    public  List<user> getAllUser(){
         List<user> ulist=userimpl.getUser();
         return ulist;
    }
    public user getUserByName(String name){
       user u =userimpl.getUserByName(name);
         return u;
    }
    public int setUser(user u){
        return userimpl.setUser(u);
    }
    public int editUser(user u){ return userimpl.editUser(u);}
    public user getUserById(int userid){
          return userimpl.getUserById(userid);
    }
    public int  addUserInfo(userInfo ui){
        return uii.addUserBaseInfo(ui);
    }
    public userInfo getUserBaseInfo(int userid){
        return uii.getUserBaseInfo(userid);
    }
    public int editUserBaseInfo(userInfo ui){
        return uii.editUserBaseInfo(ui);
    }
}
