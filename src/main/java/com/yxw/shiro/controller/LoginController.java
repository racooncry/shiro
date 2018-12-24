package com.yxw.shiro.controller;

import com.yxw.shiro.domain.Role;
import com.yxw.shiro.domain.User;
import com.yxw.shiro.domain.response.Result;
import com.yxw.shiro.enums.ResultEnum;
import com.yxw.shiro.service.IUserService;
import com.yxw.shiro.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

/**
 * @Author: yxw
 * @Date: 2018/12/21 14:40
 * @Description:
 * @Version 1.0
 */
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private IUserService userService;

//    @RequestMapping("/login")
//    public String login(HttpServletRequest request, Map<String ,String> map){
//        System.out.println("user login .....");
//        String exception = (String) request.getAttribute("shiroLoginFailure");
//        System.out.println("exception=" + exception);
//        String msg = "";
//        if (exception != null) {
//            if (UnknownAccountException.class.getName().equals(exception)) {
//                System.out.println("UnknownAccountException -- > 账号不存在：");
//                msg = "unknownAccount";
//            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
//                msg = "incorrectPassword";
//            } else if ("kaptchaValidateFailed".equals(exception)) {
//                System.out.println("kaptchaValidateFailed -- > 验证码错误");
//                msg = "kaptchaValidateFailed -- > 验证码错误";
//            } else {
//                msg = "else >> "+exception;
//                System.out.println("else -- >" + exception);
//            }
//        }
//        map.put("msg", msg);
//        //认证成功由shiro框架自行处理
//        return "login";
//    }


    /**
     * post表单提交，登录
     *
     * @param username
     * @param password
     * @param
     * @return
     */
    @PostMapping("/login")
    public Result login(String username, String password) {
        Subject userShiro = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //shiro帮我们匹配密码什么的，我们只需要把东西传给它，它会根据我们在UserRealm里认证方法设置的来验证
        userShiro.login(token);
        log.info("验证通过");
        //根据权限，指定返回数据
        User user = userService.findUserByName(username);
        List<Role> roles = user.getRoleList();
        for (Role role : roles) {
            System.out.println(role.getRolename());
            if ("admin".equals(role.getRolename())) {
                return ResultUtil.successWithMessageNoData("欢迎来到管理员页面");
            }
            if ("user".equals(role.getRolename())) {
                return ResultUtil.successWithMessageNoData("欢迎登陆");
            }
        }
        return ResultUtil.fail(ResultEnum.PERMISSION_NOT_ENUGH);
    }

    /**
     * 退出
     *
     * @return
     */
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return ResultUtil.successWithMessageNoData("成功注销！");
    }


    @GetMapping(value = "/notLogin")
    public Result notLogin() {
        return ResultUtil.fail(ResultEnum.NOT_LOGIN);
    }

    @GetMapping(value = "/notRole")
    public Result notRole() {
        return ResultUtil.fail(ResultEnum.PERMISSION_NOT_ENUGH);
    }









    //访问此连接时会触发MyShiroRealm中的权限分配方法
    @RequestMapping("/permission")
    @RequiresPermissions("student:test")
    public void test() {
        System.out.println("permission  test");
    }


}
