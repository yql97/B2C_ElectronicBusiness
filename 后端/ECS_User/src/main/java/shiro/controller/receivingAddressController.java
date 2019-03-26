package shiro.controller;

import ECS_Common.util.ReqResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shiro.entity.receivingAddress;
import shiro.service.receivingAddressService;

import java.util.List;
@Controller
@RequestMapping("/receiveAddress")
public class receivingAddressController {
    @Autowired
    private receivingAddressService ras;

    @RequestMapping(value ="/addReceiveAddress.action",method = RequestMethod.POST)
    @ResponseBody
    public String addReceiveAddress(@ModelAttribute("receivingAddress") receivingAddress receive_address){
         int is_default =receive_address.getIs_default();
         if(is_default==1){
         }else{
          receive_address.setIs_default(0);}
        int status=ras.addReceivingAddress(receive_address);
        if(status==1) return ReqResultUtil.getSuccessResponse();
        return ReqResultUtil.getFailedResponse();
    }
    @RequestMapping(value ="/updateReceiveAddress.action",method = RequestMethod.POST)
    @ResponseBody
    public String  updateReceiveAddress(@ModelAttribute("receivingAddress")receivingAddress receive_address){
        int status=ras.updateReceivingAddress(receive_address);
        if(status==1) return ReqResultUtil.getSuccessResponse();
        return ReqResultUtil.getFailedResponse();
    }
    @RequestMapping(value ="/deleteReceiveAddress.action",method = RequestMethod.GET)
    @ResponseBody
    public String  deleteReceiveAddress(@RequestParam("user_id") int userid,
                                        @RequestParam("receiveAddress_id") int receiveAddress_id){
        int status=0;
        receivingAddress receive_address  =ras.selectReceivingAddressById(receiveAddress_id);
        if(receive_address.getUser_id()==userid)  status=ras.deleteReceivingAddress(receive_address);
        if(status==1) return ReqResultUtil.getSuccessResponse();
        return ReqResultUtil.getFailedResponse();
    }
    @RequestMapping(value ="/setIsDefault.action",method = RequestMethod.GET)
    @ResponseBody
    public String  setIsDefault(@RequestParam("user_id") int userid,@RequestParam("receiveAddress_id")  int receiveAddress_id){
        receivingAddress receive_address =ras.selectReceivingAddressById(receiveAddress_id);
        int status=ras.setIsDefault(userid,receive_address);
        if(status==1) return ReqResultUtil.getSuccessResponse();
        return ReqResultUtil.getFailedResponse();
    }
    @RequestMapping(value ="/getReceiveAddressInfo.action",method = RequestMethod.GET)
    @ResponseBody
    public String  getReceiveAddressInfo(@RequestParam("receiveAddress_id")  int id){
        receivingAddress receive_address =ras.selectReceivingAddressById(id);
        return ReqResultUtil.getSuccessResponse(receive_address);
    }
    @RequestMapping(value ="/getReceiveAddressList.action",method = RequestMethod.GET)
    @ResponseBody
    public String  getReceiveAddressList(@RequestParam("user_id")  int userid){
           List<receivingAddress> rlist=ras.selectReceivingAddressByUser(userid);
        return ReqResultUtil.getSuccessResponse(rlist);
    }
}
