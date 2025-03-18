package com.dk.auth.common.enums;

import lombok.Getter;

/**
 * 是否枚举类
 * @author 23247
 */

@Getter
public enum YesOrNoEnum {

    YES(1, "是"),
    NO(0, "否");

    private Integer code;
    private String message;

    YesOrNoEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过code编码获取对应信息描述
     * @param code 编码
     * @return 信息描述
     */
    public String getMessage(int code) {
        for (YesOrNoEnum resultCodeEnum : YesOrNoEnum.values()) {
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
        for (YesOrNoEnum resultCodeEnum : YesOrNoEnum.values()) {
            if (resultCodeEnum.getMessage().equals(message)) {
                return resultCodeEnum.getCode();
            }
        }
        return null;
    }
}
