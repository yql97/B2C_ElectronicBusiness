package shiro.controller;

import ECS_Common.util.ReqResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import shiro.entity.user;
import shiro.service.userService;
import java.util.List;
@Controller("/userSecurity")
public class SecurityController {

    @Autowired
    private userService userService;

    @RequestMapping(value="alterLoginPassword.action",method=RequestMethod.POST)
    @ResponseBody
    public String alterLoginPassword(int userid,String older_password,String new_password,int code){
        user u=userService.getUserById(userid);
        if(!u.getUserpassword().equals(older_password)) return ReqResultUtil.getFailedResponse();
        u.setUserpassword(new_password);
        userService.editUser(u);
        return ReqResultUtil.getSuccessResponse("成功");
    }
    @RequestMapping(value="setPayPassword.action",method=RequestMethod.POST)
    @ResponseBody
    public String setPayPassword(int userid,int paypassword,int code){
        user u=userService.getUserById(userid);
        u.setPayPassword(paypassword);
        return ReqResultUtil.getSuccessResponse("成功");
    }
    @RequestMapping(value="alterPayPassword.action",method=RequestMethod.POST)
    @ResponseBody
    public String alterPayPassword(int userid,int old_paypassword,int new_paypassword,int code){
        user u=userService.getUserById(userid);
        if(u.getPayPassword()!=old_paypassword) return ReqResultUtil.getFailedResponse();
        u.setPayPassword(new_paypassword);
        userService.editUser(u);
        return ReqResultUtil.getSuccessResponse("成功");
    }
    @RequestMapping(value="alterPhoneNumber.action",method=RequestMethod.POST)
    @ResponseBody
    public String alterPhoneNumber(int userid,String phone_num,int code){
              user u=userService.getUserById(userid);
              u.setPhonenumber(phone_num);
              userService.editUser(u);
        return ReqResultUtil.getSuccessResponse("成功");
    }
    @RequestMapping(value="alterEmailNumber.action",method=RequestMethod.POST)
    @ResponseBody
    public String alterEmailNumber(int userid,String email_num,int code){
        user u=userService.getUserById(userid);
        u.setMailnumber(email_num);
        userService.editUser(u);
        return ReqResultUtil.getSuccessResponse("成功");
    }
    @RequestMapping(value="getPayPasswordStatus.action",method=RequestMethod.GET)
    @ResponseBody
    public String getPayPasswordStatus(int userid){
        user u=userService.getUserById(userid);
        return ReqResultUtil.getSuccessResponse("成功");
    }

}
