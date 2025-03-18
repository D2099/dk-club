package com.dk.auth.common.enums;

import lombok.Getter;

/**
 * 状态码枚举类
 * @author 23247
 */

@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过code编码获取对应信息描述
     * @param code 编码
     * @return 信息描述
     */
    public String getMessage(int code) {
        for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()) {
            if (resultCodeEnum.getCode() == code) {
                return resultCodeEnum.getMessage();
            }
        }
        return null;
    }

    /**
     * 通过信息描述获取对应code编码
     * @param message 信息描述
     * @return 编码
     */
    public Integer getCode(String message) {
        for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()) {
            if (resultCodeEnum.getMessage().equals(message)) {
                return resultCodeEnum.getCode();
            }
        }
        return null;
    }
}
