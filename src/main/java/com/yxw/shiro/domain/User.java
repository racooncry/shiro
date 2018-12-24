package com.yxw.shiro.domain;

import java.util.List;

/**
 * @Author: yxw
 * @Date: 2018/12/21 14:32
 * @Description:
 * @Version 1.0
 */
public class User {
    private int id;
    private String username;
    private String password;

    //用户的角色   一对多关系
    private List<Role> roleList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }


}
