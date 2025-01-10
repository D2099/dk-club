package com.dk.subject.common.enums;

import lombok.Getter;

/**
 * 删除状态枚举类
 * @author 23247
 */

@Getter
public enum DeleteFlagEnum {

    DELETE(1, "已删除"),
    UN_DELETE(0, "未删除");

    private Integer code;
    private String message;

    DeleteFlagEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过code编码获取对应信息描述
     * @param code 编码
     * @return 信息描述
     */
    public String getMessage(int code) {
        for (DeleteFlagEnum resultCodeEnum : DeleteFlagEnum.values()) {
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
        for (DeleteFlagEnum resultCodeEnum : DeleteFlagEnum.values()) {
            if (resultCodeEnum.getMessage().equals(message)) {
                return resultCodeEnum.getCode();
            }
        }
        return null;
    }
}
