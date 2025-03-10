package com.dk.oss.config;

import com.dk.oss.enums.OssTypeEnum;
import com.dk.oss.adapter.StorageAdapter;
import com.dk.oss.adapter.AliStorageAdapter;
import com.dk.oss.adapter.MinioStorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Value("${storage.service.type}")
    private String serviceType;

    @Bean("storageService")
    public StorageAdapter getStorageService() {
        OssTypeEnum ossTypeEnum = OssTypeEnum.getEnumByCode(serviceType);
        if (OssTypeEnum.MINIO.equals(ossTypeEnum)) {
            return new MinioStorageAdapter();
        } else if (OssTypeEnum.ALIYUN.equals(ossTypeEnum)) {
            return new AliStorageAdapter();
        }
        return null;
    }
}
