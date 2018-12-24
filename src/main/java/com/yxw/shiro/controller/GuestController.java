package com.yxw.shiro.controller;

import com.yxw.shiro.domain.response.Result;
import com.yxw.shiro.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yxw
 * @Date: 2018/12/22 18:47
 * @Description: 游客
 * @Version 1.0
 */

@RestController
@RequestMapping("/guest")
public class GuestController {
    @GetMapping(value = "/enter")
    public Result login() {
        return ResultUtil.successWithMessageNoData("欢迎进入，您的身份是游客");
    }

    @GetMapping(value = "/getMessage")
    public Result submitLogin() {
        return ResultUtil.successWithMessageNoData("您拥有获得该接口的信息的权限！");
    }
}
