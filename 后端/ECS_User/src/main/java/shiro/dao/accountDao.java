package main.java.shiro.dao;

import main.java.shiro.entity.account;

public interface accountDao {
    public account selectByUserId(int id);
    public account selectById(String id);
    public int addAccount(account account);
    public int addAccountBalance(account account,double add_num);
    public int subAccountBalance(account account,double sub_num);
    public int deleteAccountBalance(account account);
}
