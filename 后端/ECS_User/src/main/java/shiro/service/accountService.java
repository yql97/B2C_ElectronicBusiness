package shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiro.dao.impl.accountImpl;
import shiro.dao.impl.bankCardImpl;
import shiro.entity.account;
import shiro.entity.bankCard;

@Service
public class accountService {
    @Autowired
    private accountImpl aI;
    @Autowired
    private bankCardImpl bcI;

    public account selectAccount(String id){
        account a=null;
         a=aI.selectById(id);
       return a;
    }
    public account selectUserAccount(int userid){
                 account a=null;
                 a=aI.selectByUserId(userid);
                 return a;
    }
    public int createAccount(account account){
        int count=aI.addAccount(account);
        if(count>0) return count;
        return 0;
    }
    public int transferAccounts(account pay_account,account recive_account,double transfer_number){ //转账or平台账户付款
         int status =0;
         status=aI.subAccountBalance(pay_account,transfer_number);
         if(status==1)  status=status+aI.addAccountBalance(recive_account,transfer_number);
         if(status==2) return 1;
         return 0;
         }
    public int withdraw(account pay_account,bankCard bank_card, double number){//提现
        int status =0;
        status=aI.subAccountBalance(pay_account,number);
        if(status==1)  status=status+bcI.addBankCardBalance(bank_card,number);
        if(status==2) return 1;
        return 0;
    }
    public int recharge(account recive_account,bankCard pay_bank_card,double number){ //充值
        int status =0;
        status=bcI.subBankCardBalance(pay_bank_card,number);
        if(status==1)  status=status+aI.addAccountBalance(recive_account,number);
        if(status==2) return 1;
        return 0;
    }
    public int bindAccountBankCard(account account){
         return aI.addAccountBankCardNum(account);

    }
    public int deleteAccountBankCard(account account){
          return aI.subAccountBankCardNum(account);
    }
}
