package com.dk.oss.controller;

import com.dk.oss.entity.BucketInfo;
import com.dk.oss.service.FileService;
import com.dk.oss.util.MinioUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * @author 23247
 */
@RefreshScope
@RestController
// @RequestMapping("/oss")
public class OssController {

    @Resource
    private MinioUtil minioUtil;

    @Resource
    private FileService fileService;

    @Value("${storage.service.type}")
    private String serviceType;

    /**
     * 请求测试
     * @return
     */
    @GetMapping("/ossTest")
    public String ossTest(){
        return "测试啊~";
    }

    /**
     * Nacos动态配置请求测试
     * @return
     */
    @GetMapping("/nacosTest")
    public String nacosTest(){
        return serviceType;
    }

    /**
     * 列出全部桶名称
     * @return
     * @throws Exception
     */
    @GetMapping("/getAllBucketName")
    public String getAllBucketName() throws Exception {
        return minioUtil.getBucketNameList().stream().map(BucketInfo::getBucketName).collect(Collectors.joining(","));
    }

    /**
     * 获取图片文件预览URL
     * @param bucketName 桶名称
     * @param objectName 路径+对象名称
     * @return
     * @throws Exception
     */
    @GetMapping("/getPreviewFileUrl")
    public String getPreviewFileUrl(@RequestParam("bucketName") String bucketName,
                                    @RequestParam("objectName") String objectName) throws Exception {
        return minioUtil.getPreviewFileUrl(bucketName, objectName);
    }

    /**
     * 获取全部桶列表
     * @return
     */
    @GetMapping("/getAllBucketList")
    public String getAllBucketList() {
        return fileService.getAllBucketNames();
    }
}
