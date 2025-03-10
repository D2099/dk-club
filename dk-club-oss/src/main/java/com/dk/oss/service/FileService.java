package com.dk.oss.service;

import com.dk.oss.config.StorageConfig;
import com.dk.oss.entity.BucketInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FileService {

    @Resource(name = "storageService")
    private StorageService storageService;

    public String getAllBucketNames() {
        return storageService.getBucketNameList().stream()
                .map(BucketInfo::getBucketName)
                .collect(Collectors.joining(","));
    }
}
