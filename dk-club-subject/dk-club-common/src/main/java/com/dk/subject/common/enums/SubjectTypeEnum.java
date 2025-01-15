package com.dk.subject.common.enums;

import lombok.Getter;

import java.util.Set;

/**
 * 题目类型枚举类
 * @author 23247
 */

@Getter
public enum SubjectTypeEnum {

    RADIO(1, "单选题"),
    MULTIPLE(2, "多选题"),
    JUDGE(3, "判断题"),
    BRIEF(4, "简答题");

    private Integer code;
    private String message;

    SubjectTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过Code编码获取枚举类型
     * @param code
     * @return
     */
    public static SubjectTypeEnum getByCode(int code) {
        SubjectTypeEnum[] subjectTypeEnums = SubjectTypeEnum.values();
        for (SubjectTypeEnum subjectTypeEnum : subjectTypeEnums) {
            if (subjectTypeEnum.getCode() == code) {
                return subjectTypeEnum;
            }
        }
        return null;
    }

    /**
     * 通过code编码获取对应信息描述
     * @param code 编码
     * @return 信息描述
     */
    public String getMessage(int code) {
        for (SubjectTypeEnum resultCodeEnum : SubjectTypeEnum.values()) {
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
        for (SubjectTypeEnum resultCodeEnum : SubjectTypeEnum.values()) {
            if (resultCodeEnum.getMessage().equals(message)) {
                return resultCodeEnum.getCode();
            }
        }
        return null;
    }
}
