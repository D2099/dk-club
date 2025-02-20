package com.dk.oss.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 桶信息类
 * @author 23247
 */
@Data
@Accessors(chain = true)
public class BucketInfo {

    /**
     * 桶名称
     */
    private String bucketName;
}
