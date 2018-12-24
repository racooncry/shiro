package com.yxw.shiro.dao;

import com.yxw.shiro.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: yxw
 * @Date: 2018/12/21 14:36
 * @Description:
 * @Version 1.0
 */
@Repository
public interface IUserDao {
    public User findUserByName(String name);
}
