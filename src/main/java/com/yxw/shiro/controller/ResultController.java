package com.yxw.shiro.controller;

import com.yxw.shiro.domain.response.Json;
import com.yxw.shiro.domain.response.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yxw
 * @Date: 2018/12/22 17:25
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("test")
public class ResultController {
    // shiro.loginUrl映射到这里，我在这里直接抛出异常交给GlobalExceptionHandler来统一返回json信息，
    // 您也可以在这里json，不过这样子就跟GlobalExceptionHandler中返回的json重复了。
    @RequestMapping("/401")
    public Result page401() {
        return new Result(401,"用户不存在");
    }

    // shiro.unauthorizedUrl映射到这里。由于demo3统一约定了url方式只做鉴权控制，不做权限访问控制，
    // 也就是说在ShiroConfig中如果没有roles[js],perms[mvn:install]这样的权限访问控制配置的话，
    // 是不会跳转到这里的。
    @RequestMapping("/403")
    public Result page403() {
        return new Result(403,"用户未登录");
    }

    @RequestMapping("/402")
    public Result page402() {
        return new Result(403,"用户名或者密码错误");
    }



//    @RequestMapping("/index")
//    public Json pageIndex() {
//        return new Json("index",true,1,"index page",null);
//    }

}
