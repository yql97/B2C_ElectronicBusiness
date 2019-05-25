package main.java.shiro.dao;

import main.java.shiro.entity.receivingAddress;
import java.util.List;
public interface receivingAddressDao {
    public List<receivingAddress> selectByUserId(int id);
    public int addReceivingAddress(receivingAddress receiving_address);
    public int updateReceivingAddress(receivingAddress receiving_address);
    public int deleteReceivingAddress(receivingAddress receiving_address);
}
