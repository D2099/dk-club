package com.dk.subject.common.entity;

import com.dk.subject.common.enums.ResultCodeEnum;
import lombok.Data;

/**
 * 响应结果封装类
 * @Description: 返回结果
 */

@Data
public class Result<T> {

    private T data;

    private int code;

    private long timestamp;

    private String message;

    private Boolean success;

    public static<T> Result<T> ok() {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        result.setSuccess(true);
        result.setTimestamp(System.currentTimeMillis());
        return result;
    }

    public static<T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        result.setData(data);
        result.setSuccess(true);
        result.setTimestamp(System.currentTimeMillis());
        return result;
    }

    public static<T> Result<T> fail() {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(ResultCodeEnum.FAIL.getMessage());
        result.setSuccess(false);
        result.setTimestamp(System.currentTimeMillis());
        return result;
    }

    public static<T> Result<T> fail(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(ResultCodeEnum.FAIL.getMessage());
        result.setData(data);
        result.setSuccess(false);
        result.setTimestamp(System.currentTimeMillis());
        return result;
    }

    public static<T> Result<T> fail(String message) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(message);
        result.setData(null);
        result.setSuccess(false);
        result.setTimestamp(System.currentTimeMillis());
        return result;
    }
}
