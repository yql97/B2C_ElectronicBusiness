package main.java.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shiro.entity.user;
import shiro.service.userService;
import shiro.util.IpUtil;
import shiro.util.RedisUtils;
import shiro.util.ReqResultUtil;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author yueqiulin
 *
 */
@Controller("/user")
public class userController {
	@Autowired
	private RedisUtils redisUtil;
	@Autowired
	private userService userService;

	@RequestMapping("/login.action") //url
	public String dologin(@ModelAttribute("user") user user, Model model,HttpServletRequest request){
        String ip = IpUtil.getIpAddress(request);
		System.out.println(ip);
		System.out.println(user.getUsername()+user.getUserpassword());
		List<user> ulist = userService.getAllUser();
		System.out.print(ulist.get(0).getUserpassword());
		Subject s=SecurityUtils.getSubject();
		if(s.isAuthenticated()){
			return "redirect:/loginSuccess.action";
		} else {

			//AuthenticationToken token
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getUserpassword().toCharArray(), null);
			//token.setRememberMe(true);
			try {
				s.login(token);
				//是否记住密码
				token.setRememberMe(true);
			} catch (UnknownAccountException ex) {
					token.clear();
				System.out.println("用户不存在或者密码错误！");
				//return "用户不存在或者密码错误！";
			} catch (IncorrectCredentialsException ex) {
					token.clear();
				System.out.println("用户不存在或者密码错误！");
				//return "用户不存在或者密码错误！";
			} catch (AuthenticationException ex) {
					token.clear();
				System.out.println(ex.getMessage());
				System.out.println("认证失败");
				//return ex.getMessage(); // 自定义报错信息
			} catch (Exception ex) {
					token.clear();
				System.out.println("错误4");
				ex.printStackTrace();
				//return "内部错误，请重试！";
			}
		}
		if(s.isAuthenticated()) 	return "redirect:/loginSuccess.action";
		return "redirect:/tologin.action";
		}

		@RequestMapping("/logout.action")
		@ResponseBody
	   public String logout() throws IOException {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			try{
				subject.logout();
			}catch(Exception ex){ }
		}
		return "redirect:/tologin.action";
	}
	@RequestMapping(value = "/register.action",method = RequestMethod.POST)
	@ResponseBody
    public String register(@ModelAttribute("user") user user){
		userService.setUser(user);
		return "";
	}
	@RequestMapping("/loginSuccess.action")
	public String loginSuccess(Model model){
	Subject subject = SecurityUtils.getSubject();
	boolean status =subject.hasRole("admin");
  if(status)	System.out.print("有admin权限");
	Session s = subject.getSession();
	s.setAttribute("sessionkey","这是一个session");
	user u= new user("qwert","123456");
	s.setAttribute("userkey",u);
	/*redisUtil.remove("userid");
	redisUtil.set("userid",u,new Integer(120).longValue());
	User user=(User)redisUtil.get("userid");
	System.out.println(user.getUsername()+user.getUserpassword());*/
		return "success";
	}


}
