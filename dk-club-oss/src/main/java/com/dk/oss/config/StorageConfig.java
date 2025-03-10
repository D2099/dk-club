package com.dk.oss.config;

import com.dk.oss.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Value("${storage.service.type}")
    private String serviceType;

    @Resource
    private StorageService aliStorageService;
    
    @Resource
    private StorageService minioStorageService;

    @Bean("storageService")
    public StorageService getStorageService() {
        if ("ali".equals(serviceType)) {
            return aliStorageService;
        } else if ("minio".equals(serviceType)) {
            return minioStorageService;
        }
        return null;
    }
}
