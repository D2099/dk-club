package com.dk.oss.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文件信息类
 * @author 23247
 */
@Data
@Accessors(chain = true)
public class FileInfo {

    /**
     * 对象名称
     */
    private String objectName;

    /**
     * 是否是文件夹
     */
    private Boolean directoryFlag;

    /**
     * eTag
     */
    private String eTag;

    /**
     * 大小
     */
    private Long size;
}
