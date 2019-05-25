package main.java.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiro.dao.impl.accountImpl;
import shiro.dao.impl.bankCardImpl;
import shiro.entity.account;
import shiro.entity.bankCard;

import java.util.List;

@Service
public class bankCardService {
    @Autowired
    private bankCardImpl bcI;
    @Autowired
    private accountImpl aI;

    public  List<bankCard> selectAccountBankCardList(int account_id){

         List<bankCard> blist=bcI.selectByAccountId(account_id);
        return blist;
    }
    public int addBankCard(bankCard bank_card){

          int row=bcI.addBankCard(bank_card);
        return row;
    }
    public bankCard selectBankCard(String id){

           bankCard bc =bcI.selectById(id);
        return bc;
    }
    public int payByBankCard(bankCard bank_card, account receive_account, int num){

                int status=0;
                status=bcI.subBankCardBalance(bank_card,num);
                if(status==1)  status=status+aI.addAccountBalance(receive_account,num);
                if(status==2)  return 1;
        return 0;
    }
    public int deleteAccountBankCard(bankCard bank_card){

        int row =bcI.deleteBankCard(bank_card);
        return row;
    }
}
