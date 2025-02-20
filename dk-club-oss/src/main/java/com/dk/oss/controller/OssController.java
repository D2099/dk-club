package com.dk.oss.controller;

import com.dk.oss.entity.BucketInfo;
import com.dk.oss.util.MinioUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/oss")
public class OssController {

    @Resource
    private MinioUtil minioUtil;

    /**
     * 请求测试
     * @return
     */
    @GetMapping("/ossTest")
    public String ossTest(){
        return "测试啊~";
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
}
