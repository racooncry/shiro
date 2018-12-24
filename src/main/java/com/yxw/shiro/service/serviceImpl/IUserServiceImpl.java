package com.yxw.shiro.service.serviceImpl;

import com.yxw.shiro.dao.IUserDao;
import com.yxw.shiro.domain.User;
import com.yxw.shiro.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yxw
 * @Date: 2018/12/21 14:33
 * @Description:
 * @Version 1.0
 */
@Service
@Slf4j
public class IUserServiceImpl implements IUserService {
    @Autowired
    IUserDao iUserDao;

    @Override
    public User findUserByName(String name) {
        log.info("查找用户名：{}",name);
        return iUserDao.findUserByName(name);
    }
}
