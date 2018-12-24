package com.yxw.shiro.controller;

import com.yxw.shiro.domain.response.Result;
import com.yxw.shiro.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yxw
 * @Date: 2018/12/22 18:46
 * @Description: admin
 * @Version 1.0
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    @RequiresPermissions("menu")
    @GetMapping(value = "/getMessage")
    public Result getMessage() {
        return ResultUtil.successWithMessageNoData("您拥有管理员权限，可以获得该接口的信息！");
    }
}
