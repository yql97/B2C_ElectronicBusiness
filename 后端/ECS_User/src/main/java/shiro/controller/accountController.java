package main.java.shiro.controller;

import shiro.util.ReqResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shiro.entity.account;
import shiro.entity.bankCard;
import shiro.entity.peopleCard;
import shiro.service.accountService;
import shiro.service.bankCardService;
import shiro.service.peopleCardService;

import java.util.List;

@Controller
@RequestMapping("/account")
public class accountController {
    @Autowired
    private accountService as;
    @Autowired
    private bankCardService bcs;
    @Autowired
    private peopleCardService pcs;

    @RequestMapping(value ="/getAccountInfo.action",method = RequestMethod.GET)
    @ResponseBody
    public String getAccountInfo(@RequestParam("user_id") int userid){
       account a =as.selectUserAccount(userid);
        return ReqResultUtil.getSuccessResponse(a);
    }
    @RequestMapping(value ="/selectAccountInfo.action",method = RequestMethod.GET)
    @ResponseBody
    public String selectAccountInfo(@RequestParam("account_code") String id){
        account a =as.selectAccount(id);
        if(a==null) return ReqResultUtil.getFailedResponse();
        return ReqResultUtil.getSuccessResponse(a);
    }
    @RequestMapping(value ="/rechargeAccount.action",method = RequestMethod.POST)
    @ResponseBody                                   //充值
    public String rechargeAccount(@RequestParam("user_id") int userid,@RequestParam("bankCard_code") String pay_bankCard_code,
                                  @RequestParam("number") double number){
        account a=as.selectUserAccount(userid);
        bankCard bc=bcs.selectBankCard(pay_bankCard_code);
        if(bc.getBank_card_balance()<number) return ReqResultUtil.getFailedResponse();
        int status=as.recharge(a,bc,number);
        if(status==1) return ReqResultUtil.getSuccessResponse();
        return ReqResultUtil.getFailedResponse();
    }
    @RequestMapping(value ="/withdrawAccount.action",method = RequestMethod.POST)
    @ResponseBody                         //提现
    public String withdrawAccount(@RequestParam("user_id") int userid, @RequestParam("bankCard_code") String receive_bankCard_code,
                                  @RequestParam("number") double number){
        account a=as.selectUserAccount(userid);
        if(a.getBalance()<number) return ReqResultUtil.getFailedResponse();
        bankCard bc=bcs.selectBankCard(receive_bankCard_code);
        int status=as.withdraw(a,bc,number);
        if(status==1) return ReqResultUtil.getSuccessResponse();
        return ReqResultUtil.getFailedResponse();
    }
    @RequestMapping(value ="/bindingBankCard.action",method = RequestMethod.POST)
    @ResponseBody
    public String bindingBankCard(@RequestParam("user_id") int userid,@ModelAttribute("bankCard") bankCard bank_card){
        int status=0;
        peopleCard pc=pcs.selectPeopleCard(userid);
        if(pc==null) return ReqResultUtil.getFailedResponse();
        account a=as.selectUserAccount(userid);
        bank_card.setAccount_id(a.getAccount_id());
        bank_card.setOwner_id(pc.getCard_num());
        bank_card.setStatus(0);
        status =bcs.addBankCard(bank_card);
        if(status==1) status=status+as.bindAccountBankCard(a);
        if(status==2) return ReqResultUtil.getSuccessResponse();
        return ReqResultUtil.getFailedResponse();
    }
    @RequestMapping(value ="/deleteBankCard.action",method = RequestMethod.POST)
    @ResponseBody
    public String deleteBankCard(@RequestParam("user_id") int userid,@RequestParam("bankCard_code") String bank_card_code){
        int status=0;
        account a=as.selectUserAccount(userid);
        bankCard bank_card = bcs.selectBankCard(bank_card_code);
        status=bcs.deleteAccountBankCard(bank_card);
        if(status==1) status=status+as.deleteAccountBankCard(a);
        if(status==2) return ReqResultUtil.getSuccessResponse();
        return ReqResultUtil.getFailedResponse();
    }
    @RequestMapping(value ="/getBankCardList.action",method = RequestMethod.GET)
    @ResponseBody
    public String getBankCardList(@RequestParam("user_id") int userid){
             account a= as.selectUserAccount(userid);
             if(a==null)  return ReqResultUtil.getFailedResponse();
             List<bankCard> bclist =bcs.selectAccountBankCardList(a.getAccount_id());
             return  ReqResultUtil.getSuccessResponse(bclist);
    }

}
