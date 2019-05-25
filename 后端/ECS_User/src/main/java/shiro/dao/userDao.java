package main.java.shiro.dao;


/**
 * @author yueqiulin
 *
 */

import main.java.shiro.entity.user;

import java.util.List;
public interface userDao {
 public List<user> getUser();
 public user getUserByName(String username);
}
