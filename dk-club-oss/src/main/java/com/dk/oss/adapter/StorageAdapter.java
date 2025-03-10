package com.dk.oss.adapter;

import com.dk.oss.entity.BucketInfo;
import com.dk.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface StorageAdapter {

    /**
     * 创建桶
     * @param bucketName
     * @throws Exception
     */
    void createBucket(String bucketName);

    /**
     * 获取桶名称列表
     * @return
     * @throws Exception
     */
    List<BucketInfo> getBucketNameList();

    /**
     * 上传文件
     * @param multipartFile 多文件输入流
     * @param bucketName 桶名称
     * @param objectName 对象名称
     * @throws Exception
     */
    void uploadFile(MultipartFile multipartFile, String bucketName, String objectName);

    /**
     * 获取指定桶内所有文件信息
     * @param bucketName 桶名称
     * @return
     * @throws Exception
     */
    List<FileInfo> getBukcketAllFileInfoList(String bucketName);

    /**
     * 下载文件
     * @param bucketName 桶名称
     * @param objectName 对象名称
     * @return
     * @throws Exception
     */
    InputStream downloadFile(String bucketName, String objectName);

    /**
     * 删除桶
     * @param bucketName 桶名称
     * @throws Exception
     */
    void deleteBucket(String bucketName);

    /**
     * 删除对象
     * @param bucketName 桶名称
     * @param objectName 对象名称
     * @throws Exception
     */
    void deleteObject(String bucketName, String objectName);

    /**
     * 获取图片文件预览链接
     * @param bucketName 桶名称
     * @param objectName 对象名称
     * @throws Exception
     */
    String getPreviewFileUrl(String bucketName, String objectName);
}
