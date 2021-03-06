package com.guoyicap.micro.config;

import com.guoyicap.micro.common.base.MsgModel;
import com.guoyicap.micro.config.user.model.Role;
import com.guoyicap.micro.config.user.model.Rule;
import com.guoyicap.micro.config.user.model.User;
import com.guoyicap.micro.config.user.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user  = (User)principals.getPrimaryPrincipal();
        if(null == user.getRoles()) {
        	 return authorizationInfo;
        }
        for(Role role:user.getRoles()){
            authorizationInfo.addRole(role.getName());
            if(null == role.getRules()) {
           	 continue;
            }
            for(Rule p:role.getRules()){
                authorizationInfo.addStringPermission(p.getRule());
            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        //User user = restTemplate.findByUsername(username);
        User user = restTemplate.postForEntity("http://localhost:10000/micro-user/user/" + "findByUsername", username, User.class).getBody();
        System.out.println("----->>user="+user);
        if(user == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

}