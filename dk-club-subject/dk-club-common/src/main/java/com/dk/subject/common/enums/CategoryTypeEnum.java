package com.dk.subject.common.enums;

import lombok.Getter;

/**
 * 题目分类类型枚举类
 * @author 23247
 */

@Getter
public enum CategoryTypeEnum {

    PRIMARY_CATEGORY(1, "题目主分类"),
    BIG_CATEGORY(2, "题目大分类");

    private Integer code;
    private String message;

    CategoryTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过code编码获取对应信息描述
     * @param code 编码
     * @return 信息描述
     */
    public String getMessage(int code) {
        for (CategoryTypeEnum resultCodeEnum : CategoryTypeEnum.values()) {
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
        for (CategoryTypeEnum resultCodeEnum : CategoryTypeEnum.values()) {
            if (resultCodeEnum.getMessage().equals(message)) {
                return resultCodeEnum.getCode();
            }
        }
        return null;
    }
}
