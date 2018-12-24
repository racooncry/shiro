package com.yxw.shiro.util;


import com.yxw.shiro.domain.response.Result;
import com.yxw.shiro.enums.ResultEnum;


public class ResultUtil {

    /**
     * 接口返回常用的两种类型，写成单例，避免多建对象浪费内存
     * resultSuccessWithNoData：返回成功，没有其他参数
     * resultWithNoAllParams：参数校验350，参数不全
     * resultWithNotProperRange: 340，不是合理范围的值
     */
    volatile private static Result resultSuccessWithNoData = null;
    volatile private static Result resultWithNoAllParams = null;
    volatile private static Result resultWithNotProperRange = null;


    public static Result getResultWithNoAllParams() {
        if (resultWithNoAllParams == null) {
            syncInitResultWithNoAllParams();
        }
        return resultWithNoAllParams;
    }

    public static synchronized void syncInitResultWithNoAllParams() {
        if (resultWithNoAllParams == null) {
            resultWithNoAllParams = new Result(ResultEnum.INTERFACE_PARAMERROR.getCode(), ResultEnum.INTERFACE_PARAMERROR.getMessage());
        }
    }


    public static Result getResultSuccessWithNoData() {
        if (resultSuccessWithNoData == null) {
            syncInitResultSuccessWithNoData();
        }
        return resultSuccessWithNoData;
    }

    public static synchronized void syncInitResultSuccessWithNoData() {
        if (resultSuccessWithNoData == null) {
            resultSuccessWithNoData = new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
        }
    }



    public static Result getResultWithNotProperRange() {
        if (resultWithNotProperRange == null) {
            syncInitResultWithNotProperRange();
        }
        return resultWithNotProperRange;
    }

    public static synchronized void syncInitResultWithNotProperRange() {
        if (resultWithNotProperRange == null) {
            resultWithNotProperRange = new Result(ResultEnum.NOT_PROPER_RANGE.getCode(), ResultEnum.NOT_PROPER_RANGE.getMessage());
        }
    }



    public static Result fail(ResultEnum resultEnum) {
        Result result = Result.builder().code(resultEnum.getCode()).message(resultEnum.getMessage()).build();
        return result;
    }

    public static Result paramError(String errorMessage) {
        Result result = Result.builder().code(350).message(errorMessage).build();
        return result;
    }


    public static Result success(Object object) {
        Result result = Result.builder().code(200).message("成功").data(object).build();
        return result;
    }

    public static Result successWithMessageNoData(String message) {
        Result result = Result.builder().code(200).message(message).build();
        return result;
    }

}
