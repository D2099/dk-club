package com.dk.oss.service.impl;

import com.dk.oss.entity.BucketInfo;
import com.dk.oss.entity.FileInfo;
import com.dk.oss.service.StorageService;
import com.dk.oss.util.MinioUtil;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.min;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service("minioStorageService")
public class MinioStorageServiceImpl implements StorageService {

    @Resource
    private MinioUtil minioUtil;

    @SneakyThrows
    @Override
    public void createBucket(String bucketName) {
        minioUtil.createBucket(bucketName);
    }

    @SneakyThrows
    @Override
    public List<BucketInfo> getBucketNameList() {
        return minioUtil.getBucketNameList();
    }

    @SneakyThrows
    @Override
    public void uploadFile(MultipartFile multipartFile, String bucketName, String objectName) {
        createBucket(bucketName);
        if (StringUtils.isNotEmpty(objectName)) {
            minioUtil.uploadFile(multipartFile.getInputStream(), bucketName, "/" + objectName);
        } else {
            minioUtil.uploadFile(multipartFile.getInputStream(), bucketName, objectName);
        }
    }

    @SneakyThrows
    @Override
    public List<FileInfo> getBukcketAllFileInfoList(String bucketName) {
        return minioUtil.getBukcketAllFileInfoList(bucketName);
    }

    @SneakyThrows
    @Override
    public InputStream downloadFile(String bucketName, String objectName) {
        return minioUtil.downloadFile(bucketName, objectName);
    }

    @SneakyThrows
    @Override
    public void deleteBucket(String bucketName) {
        minioUtil.deleteBucket(bucketName);
    }

    @SneakyThrows
    @Override
    public void deleteObject(String bucketName, String objectName) {
        minioUtil.deleteObject(bucketName, objectName);
    }

    @SneakyThrows
    @Override
    public String getPreviewFileUrl(String bucketName, String objectName) {
        return minioUtil.getPreviewFileUrl(bucketName, objectName);
    }
}
