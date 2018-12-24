package com.yxw.shiro.handle.exception;

/**
 * @Author: yxw
 * @Date: 2018/11/13 16:33
 * @Description: 自定义exception
 * @Version 1.0
 */
public class MyException extends RuntimeException {
    public MyException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
//  throw new MyException("101", "Sam 错误");

}
