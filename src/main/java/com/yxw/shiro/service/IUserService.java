package com.yxw.shiro.service;

import com.yxw.shiro.domain.User;

/**
 * @Author: yxw
 * @Date: 2018/12/21 14:33
 * @Description:
 * @Version 1.0
 */
public interface IUserService {
    public User findUserByName(String name);
}
