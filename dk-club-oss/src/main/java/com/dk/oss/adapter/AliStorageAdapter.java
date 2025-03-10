package com.dk.oss.adapter;

import com.dk.oss.entity.BucketInfo;
import com.dk.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public class AliStorageAdapter implements StorageAdapter {
    @Override
    public void createBucket(String bucketName) {

    }

    @Override
    public List<BucketInfo> getBucketNameList() {
        BucketInfo bucketInfo = new BucketInfo()
                .setBucketName("aliyun");
        return List.of(bucketInfo);
    }

    @Override
    public void uploadFile(MultipartFile multipartFile, String bucketName, String objectName) {
    }

    @Override
    public List<FileInfo> getBukcketAllFileInfoList(String bucketName) {
        return List.of();
    }

    @Override
    public InputStream downloadFile(String bucketName, String objectName) {
        return null;
    }

    @Override
    public void deleteBucket(String bucketName) {

    }

    @Override
    public void deleteObject(String bucketName, String objectName) {

    }

    @Override
    public String getPreviewFileUrl(String bucketName, String objectName) {
        return "";
    }
}
