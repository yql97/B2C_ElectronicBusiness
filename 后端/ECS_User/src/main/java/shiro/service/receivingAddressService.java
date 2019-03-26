package shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiro.dao.impl.receivingAddressImpl;
import shiro.entity.receivingAddress;
import java.util.List;
@Service
public class receivingAddressService {
    @Autowired
    private receivingAddressImpl raI;

    public int addReceivingAddress(receivingAddress receive_address){
             return raI.addReceivingAddress(receive_address);
    }
    public int updateReceivingAddress(receivingAddress receive_address){

              return raI.updateReceivingAddress(receive_address);
    }
    public int deleteReceivingAddress(receivingAddress receive_address){
            return raI.deleteReceivingAddress(receive_address);
    }
    public  List<receivingAddress> selectReceivingAddressByUser(int user_id){
             return raI.selectByUserId(user_id);
    }
    public  receivingAddress selectReceivingAddressById(int id){
             return raI.selectById(id);
    }
    public int  setIsDefault(int userid,receivingAddress receive_address){
           return raI.setIsDefaultReceivingAddress(userid,receive_address);
    }
}
