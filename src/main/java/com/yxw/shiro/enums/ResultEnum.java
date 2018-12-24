package com.yxw.shiro.enums;

public enum ResultEnum {

    USER_NOT_EXISTS(201,"用户名不存在"),
    PASSWORD_WRONG(202,"密码错误"),
    PERMISSION_NOT_ENUGH(203,"权限不足"),
    NOT_LOGIN(204,"您尚未登录"),
    SERVER_ERROR(555, "服务器错误"),
    INTERFACE_PARAMERROR(350, "缺少必要信息"),
    SUCCESS(200, "成功!"),
    NOT_PROPER_RANGE(340,"不是合理范围值"),

   ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
