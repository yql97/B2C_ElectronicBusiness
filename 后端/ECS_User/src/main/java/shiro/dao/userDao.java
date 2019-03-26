package shiro.dao;


/**
 * @author yueqiulin
 *
 */

import shiro.entity.user;

import java.util.List;
public interface userDao {
 public List<user> getUser();
 public user getUserByName(String username);
}
