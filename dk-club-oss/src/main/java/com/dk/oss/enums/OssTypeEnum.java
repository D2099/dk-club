package com.dk.oss.enums;

import lombok.Getter;

/**
 * OSS类型枚举类
 * @author 23247
 */

@Getter
public enum OssTypeEnum {

    MINIO("minio", "minio"),
    ALIYUN("aliyun", "阿里云");

    private String code;
    private String description;

    OssTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 通过code编码获取对应信息描述
     * @param code 编码
     * @return 信息描述
     */
    public String getDescription(String code) {
        for (OssTypeEnum resultCodeEnum : OssTypeEnum.values()) {
            if (resultCodeEnum.getCode().equals(code)) {
                return resultCodeEnum.getDescription();
            }
        }
        return null;
    }

    /**
     * 通过信息描述获取对应code编码
     * @param description 信息描述
     * @return 编码
     */
    public String getCode(String description) {
        for (OssTypeEnum resultCodeEnum : OssTypeEnum.values()) {
            if (resultCodeEnum.getDescription().equals(description)) {
                return resultCodeEnum.getCode();
            }
        }
        return null;
    }

    /**
     * 通过编码获取对应枚举变量
     * @param code 编码
     * @return 对应类型枚举
     */
    public static OssTypeEnum getEnumByCode(String code) {
        for (OssTypeEnum resultCodeEnum : OssTypeEnum.values()) {
            if (resultCodeEnum.getCode().equals(code)) {
                return resultCodeEnum;
            }
        }
        return null;
    }
}
