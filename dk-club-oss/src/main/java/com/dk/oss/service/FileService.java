package com.dk.oss.service;

import com.dk.oss.adapter.StorageAdapter;
import com.dk.oss.entity.BucketInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FileService {

    @Resource(name = "storageService")
    private StorageAdapter storageAdapter;

    public String getAllBucketNames() {
        return storageAdapter.getBucketNameList().stream()
                .map(BucketInfo::getBucketName)
                .collect(Collectors.joining(","));
    }
}
