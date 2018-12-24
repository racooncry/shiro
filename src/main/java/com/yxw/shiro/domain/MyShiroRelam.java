package com.yxw.shiro.domain;

import com.yxw.shiro.enums.ResultEnum;
import com.yxw.shiro.handle.GlobalExceptionHandler;
import com.yxw.shiro.handle.exception.MyException;
import com.yxw.shiro.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: yxw
 * @Date: 2018/12/21 14:42
 * @Description:
 * @Version 1.0
 */
public class MyShiroRelam extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("用户权限配置。。。。。。。。。。");
        //访问@RequirePermission注解的url时触发
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo = (User) principals.getPrimaryPrincipal();
        //获得用户的角色，及权限进行绑定
        for (Role role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRolename());
            for (Permission p : role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    //验证用户登录信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 从数据库获取对应用户名密码的用户
        System.out.println("用户名：" + token.getUsername());
        //从数据库查询出User信息及用户关联的角色，权限信息，以备权限分配时使用
        User user = userService.findUserByName(token.getUsername());
        if (null == user) {
            throw new MyException(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMessage());
        }
        if (!user.getPassword().equals(new String((char[]) token.getCredentials()))) {
            throw new MyException(ResultEnum.PASSWORD_WRONG.getCode(), ResultEnum.PASSWORD_WRONG.getMessage());
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }

}
