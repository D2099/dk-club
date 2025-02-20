package com.dk.oss.util;

import com.dk.oss.entity.BucketInfo;
import com.dk.oss.entity.FileInfo;
import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * minio工具类
 */
@Component
public class MinioUtil {

    @Resource
    private MinioClient minioClient;

    /**
     * 创建桶
     * @param bucketName
     * @throws Exception
     */
    public void createBucket(String bucketName) throws Exception {
        boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!bucketExists) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 获取桶名称列表
     * @return
     * @throws Exception
     */
    public List<BucketInfo> getBucketNameList() throws Exception {
        List<Bucket> bucketList = minioClient.listBuckets();
        return bucketList.stream().map(bucket -> new BucketInfo().setBucketName(bucket.name())).toList();
    }

    /**
     * 上传文件
     * @param inputStream 输入流
     * @param bucketName 桶名称
     * @param objectName 对象名称
     * @throws Exception
     */
    public void uploadFile(InputStream inputStream, String bucketName, String objectName) throws Exception {
        minioClient.putObject(
                PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(inputStream, -1, Integer.MAX_VALUE).build()
        );
    }

    /**
     * 获取指定桶内所有文件信息
     * @param bucketName 桶名称
     * @return
     * @throws Exception
     */
    public List<FileInfo> getBukcketAllFileInfoList(String bucketName) throws Exception {
        Iterable<Result<Item>> results = minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).build());
        List<FileInfo> fileInfoList = new ArrayList<>();
        for (Result<Item> result : results) {
            Item item = result.get();
            fileInfoList.add(new FileInfo()
                    .setObjectName(item.objectName())
                    .setSize(item.size())
                    .setETag(item.etag())
                    .setDirectoryFlag(item.isDir()));
        }
        return fileInfoList;
    }

    /**
     * 下载文件
     * @param bucketName 桶名称
     * @param objectName 对象名称
     * @return
     * @throws Exception
     */
    public InputStream downloadFile(String bucketName, String objectName) throws Exception {
        return minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }

    /**
     * 删除桶
     * @param bucketName 桶名称
     * @throws Exception
     */
    public void deleteBucket(String bucketName) throws Exception {
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
    }

    /**
     * 删除对象
     * @param bucketName 桶名称
     * @param objectName 对象名称
     * @throws Exception
     */
    public void deleteObject(String bucketName, String objectName) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }

    /**
     * 获取图片文件预览链接
     * @param bucketName 桶名称
     * @param objectName 对象名称
     * @throws Exception
     */
    public String getPreviewFileUrl(String bucketName, String objectName) throws Exception {
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder().bucket(bucketName).object(objectName).method(Method.GET).build()
        );
    }
}
