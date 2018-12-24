package com.yxw.shiro.constant;

/**
 * @Author: yxw
 * @Date: 2018/12/22 17:07
 * @Description:
 * @Version 1.0
 */
public interface Codes {
    /** 未登录 */
    int UNAUTHEN = 4401;

    /** 未授权，拒绝访问 */
    int UNAUTHZ = 4403;

    int PASSWORD_ERROR=4402;
    /** shiro相关的错误 */
    int SHIRO_ERR = 4444;

    /** 服务端异常 */
    int SERVER_ERR = 5500;
}
