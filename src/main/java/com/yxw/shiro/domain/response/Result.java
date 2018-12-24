package com.yxw.shiro.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yangxw
 * @date: Created in 2018-06-22 9:31
 * @description:
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Result<T> {
    /**
     * 错误状态吗
     */
    public Integer code;
    /**
     * 提示信息
     */
    private String message;
    /**
     *  具体的内容
     */
    private T data;

    public Result(Integer code, String message){
        this.code=code;
        this.message=message;
    }

}
