package com.yxw.shiro.handle;

import com.yxw.shiro.domain.response.Result;
import com.yxw.shiro.enums.ResultEnum;
import com.yxw.shiro.handle.exception.MyException;
import com.yxw.shiro.util.ResultUtil;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yxw
 * @Date: 2018/12/22 18:28
 * @Description:
 * @Version 1.0
 */
@RestControllerAdvice
public class ExceptionController  {
    // 捕捉 CustomRealm 抛出的异常
    @ExceptionHandler(MyException.class)
    public Result handleShiroException(MyException e) {
        return new Result(e.getCode(),e.getMessage());
    }



//    @ExceptionHandler(UnauthenticatedException.class)
//    public Result handleUnauthenticated(UnauthenticatedException e) {
//        e.printStackTrace();
//        return ResultUtil.fail(ResultEnum.PERMISSION_NOT_ENUGH);
//    }
}
