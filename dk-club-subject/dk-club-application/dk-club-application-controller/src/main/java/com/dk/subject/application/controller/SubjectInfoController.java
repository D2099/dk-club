package com.dk.subject.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.dk.subject.application.convert.SubjectInfoDTOConverter;
import com.dk.subject.application.dto.SubjectInfoDTO;
import com.dk.subject.common.entity.PageResult;
import com.dk.subject.common.entity.Result;
import com.dk.subject.domain.bo.SubjectInfoBO;
import com.dk.subject.domain.service.SubjectInfoDomainService;
import com.dk.subject.infra.basic.entity.SubjectInfo;
import com.dk.subject.infra.basic.service.SubjectInfoService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 题目信息表 接口控制器
 * @author DEMOKING
 * @since 2025-01-14
 */
@Slf4j
@RestController
@RequestMapping("/subject-info")
public class SubjectInfoController {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

    /**
     * 通过主键ID查询一个题目信息表
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public SubjectInfo getSubjectInfo(@RequestParam("id") Long id) {
        SubjectInfo subjectInfoOne = subjectInfoService.getSubjectInfo(id);
        return subjectInfoOne;
    }

    /**
     * 查询全部题目信息表
     */
    @GetMapping("/listAll")
    public List<SubjectInfo> getAllSubjectInfo() {
        List<SubjectInfo> subjectInfoList = subjectInfoService.getAllSubjectInfo();
        return subjectInfoList;
    }

    /**
     * 新增题目信息
     * @param subjectInfoDTO com.dk.subject.application.dto.SubjectInfoDTO
     */
    @PostMapping("/add")
    public Result<Boolean> add(@Valid @RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.add.subjectInfoDTO:{}", JSONObject.toJSONString(subjectInfoDTO));
            }
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertToSubjectInfoBO(subjectInfoDTO);
            Boolean result = subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("新增题目信息失败~，原因：{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 更新题目信息表
     * @param  subjectInfo com.dk.subject.infra.basic.entity.SubjectInfo
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody SubjectInfo subjectInfo) {
        int num = subjectInfoService.modify(subjectInfo);
        return num;
    }

    /**
     * 通过主键ID删除题目信息表
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        subjectInfoService.remove(ids);
        return null;
    }

    /**
     * 获取题目列表
     * @param subjectInfoDTO com.dk.subject.application.dto.SubjectInfoDTO
     */
    @PostMapping("/getSubjectList")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@Valid @RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.getSubjectList.subjectInfoDTO:{}", JSONObject.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类ID不能为空~");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标题ID不能为空~");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertToSubjectInfoBO(subjectInfoDTO);
            PageResult<SubjectInfoBO> subjectInfoBOPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            PageResult<SubjectInfoDTO> subjectInfoDTOPageResult =
                    SubjectInfoDTOConverter.INSTANCE.convertToSubjectInfoPageResultDTO(subjectInfoBOPageResult);
            return Result.ok(subjectInfoDTOPageResult);
        } catch (Exception e) {
            log.error("获取题目列表失败~，原因：{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 获取题目详情
     * @param subjectInfoDTO com.dk.subject.application.dto.SubjectInfoDTO
     */
    @PostMapping("/getSubjectDetail")
    public Result<SubjectInfoDTO> getSubjectDetail(@Valid @RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.getSubjectDetail.subjectInfoDTO:{}", JSONObject.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getId(), "题目ID不能为空~");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertToSubjectInfoBO(subjectInfoDTO);
            SubjectInfoBO subjectInfoBOResult = subjectInfoDomainService.getSubjectDetail(subjectInfoBO);
            SubjectInfoDTO subjectInfoDTOResult = SubjectInfoDTOConverter.INSTANCE.convertToSubjectInfoDTO(subjectInfoBOResult);
            return Result.ok(subjectInfoDTOResult);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取题目详情失败~，原因：{}", e.getMessage());
             return Result.fail(e.getMessage());
        }
    }
}
