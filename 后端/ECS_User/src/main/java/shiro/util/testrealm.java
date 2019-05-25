/**
 * 
 */

package main.java.shiro.util;
/*
 * @author yueqiulin
 *
 */

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import main.java.shiro.entity.user;
import main.java.shiro.service.userService;

import java.util.HashSet;
import java.util.Set;

public class testrealm extends AuthorizingRealm  {

    @Autowired
    private userService userService;

    @Override
      public String getName() {
        return "customRealm";
     }
    @Override     /**认证*/
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=  (UsernamePasswordToken) authenticationToken;//获取认证用户信息
        String name =  token.getUsername();
        String password =String.valueOf(token.getPassword());
      System.out.println(name+password);
      user autherUser =userService.getUserByName(name);
     System.out.println(autherUser.getUsername()+autherUser.getUserpassword());

    /*    Md5Hash md5Hash =new Md5Hash("123");
      User autherUser=new User("yue",md5Hash.toString());//202cb962ac59075b964b07152d234b70
        System.out.println("错误5");
     //  String upassword= autherUser.getUserpassword();*/
       if(autherUser==null|| autherUser.getUsername()==null||autherUser.getUserpassword()==null){
            return null;
        }
        //如果为空密码为空 返回空
        SimpleAuthenticationInfo  authenticationInfo =new SimpleAuthenticationInfo(
                autherUser.getUsername(),autherUser.getUserpassword(),getName());
       // System.out.println("错误6");
        //md5加密加盐
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(autherUser.getUsername()));
        return authenticationInfo;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {

        //获取身份信息
    //  pc.getPrimaryPrincipal();
        String username =pc.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo simpleAuthorizationInfo=null;
            simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            //1.设置所有的权限(注意权限是以字符串的形式保存的权限码)
            //获取所有权限列表
         //   List<Permission> permissions1 = userService.selectPermissionsByUserId(userId);//获取所有权限码
          Set<String> permissions = new HashSet<String>();
            permissions.add("qwer123");
           //将权限id放入集合
          /*  for(Permission permission:permissions1){
                if(ValidateCheck.isNotNull(permission.getPermissioncode())){
                    permissions.add(permission.getPermissioncode());
                }
            }*/
          //将权限集合放入认证授权环境
            if (permissions != null && permissions.size()>0) {
                simpleAuthorizationInfo.setStringPermissions(permissions);
            }
            //2.给用户设置角色，角色也是以字符串的形式表示(这里存的是角色名字)
            //从数据库获取该用户的角色集合
       //     Set<String> userRoleNames = userService.getUserRoleNameByUserId(userId);
            Set<String> userRoleNames = new HashSet<String>();
            userRoleNames.add("admin");
            if(userRoleNames != null && userRoleNames.size()>0){
                simpleAuthorizationInfo.setRoles(userRoleNames);
            }
        return simpleAuthorizationInfo;


    }
  /*  public  static void  main(String []args){
        Md5Hash md5Hash =new Md5Hash("123","yue");
        System.out.println(md5Hash);

    }*/
}