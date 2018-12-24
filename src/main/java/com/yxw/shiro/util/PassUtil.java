package com.yxw.shiro.util;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * @Author: yxw
 * @Date: 2018/12/22 16:02
 * @Description:
 * @Version 1.0
 */
public class PassUtil {
    public static void main(String[] args) {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashAlgorithmName("123456");

        System.out.println(hashedCredentialsMatcher);
    }
}
