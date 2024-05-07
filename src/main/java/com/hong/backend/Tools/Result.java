package com.hong.backend.Tools;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;  // 状态码 1 成功 0 失败
    private String message; // 返回值消息提示
    private Object data; // 数据


    // 成功的状态 -- 空参
    public static<T> Result<T> success(){
        Result result = new Result();
        result.code = 1;
        return result;
    }

    // 成功的状态 -- 全参
    public static<T> Result<T> success(T object) {
        Result result = new Result();
        result.code = 1;
        result.data = object;
        return result;
    }

    // 成功的状态 -- 全参
    public static<T> Result<T> success(String msg,T object){
        Result result = new Result();
        result.code = 1;
        result.message = msg;
        result.data = object;
        return result;
    }


    // 错误返回状态
    public static <T> Result<T> error(String msg){
        Result result = new Result();
        result.code = 0;
        result.message = msg;
        return result;
    }

}

