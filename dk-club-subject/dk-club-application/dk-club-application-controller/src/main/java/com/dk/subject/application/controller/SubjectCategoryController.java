package com.dk.subject.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.dk.subject.application.convert.SubjectCategoryDTOConverter;
import com.dk.subject.application.dto.SubjectCategoryDTO;
import com.dk.subject.common.entity.Result;
import com.dk.subject.domain.bo.SubjectCategoryBO;
import com.dk.subject.domain.service.SubjectCategoryDomainService;
import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 题目分类 接口控制器
 * @author DEMOKING
 * @since 2024-12-12
 */
@Slf4j
@RestController
@RequestMapping("/subject-category")
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 通过主键ID查询一个题目分类
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public SubjectCategory getSubjectCategory(@RequestParam("id") Long id) {
        SubjectCategory subjectCategoryOne = subjectCategoryService.getSubjectCategory(id);
        return subjectCategoryOne;
    }

    /**
     * 查询全部题目分类
     */
    @GetMapping("/listAll")
    public List<SubjectCategory> getAllSubjectCategory() {
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.getAllSubjectCategory();
        return subjectCategoryList;
    }

    /**
     * 查询全部题目分类
     */
    @GetMapping("/getPrimaryCategoryList")
    public Result<List<SubjectCategoryDTO>> getPrimaryCategoryList() {
        try {
            List<SubjectCategoryBO> boList = subjectCategoryDomainService.getPrimaryCategoryList();
            List<SubjectCategoryDTO> dtoList = SubjectCategoryDTOConverter.INSTANCE.convertToSubjectCategoryBOList(boList);
            return Result.ok(dtoList);
        } catch (Exception e) {
            log.error("查询主要分类出错~，原因：{}", e.getMessage());
            return Result.fail(null);
        }
    }

    /**
     * 更新题目分类
     * @param  subjectCategoryDTO com.dk.subject.application.dto.SubjectCategoryDTO
     */
    @PostMapping("/update")
    public Result<Boolean> update(@Valid @RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.update.subjectCategoryDTO:{}", JSONObject.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE
                    .convertToSubjectCategoryBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("更新失败~，原因：{}", e.getMessage());
            return Result.fail("更新失败~");
        }
    }

    /**
     * 通过主键ID删除题目分类
     * @param subjectCategoryDTO com.dk.subject.application.entity.SubjectCategoryDTO
     */
    @PostMapping(value = "/delete")
    public Result<Boolean> remove(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.remove.subjectCategoryDTO:{}", JSONObject.toJSONString(subjectCategoryDTO));
        }
        SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertToSubjectCategoryBO(subjectCategoryDTO);
        Boolean result = subjectCategoryDomainService.remove(subjectCategoryBO);
        return Result.ok(result);
    }

    /**
     * 新增题目分类
     * @param subjectCategoryDTO com.dk.subject.application.entity.SubjectCategoryDTO
     */
    @PostMapping("/add")
    public Result<Boolean> add(@Valid @RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.subjectCategoryDTO:{}", JSONObject.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertToSubjectCategoryBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("新增题目分类失败~，原因：{}", e.getMessage());
            return Result.fail("新增题目分类失败~");
        }
    }

    /**
     * 按主ID查询大类下分类列表
     * @param subjectCategoryDTO com.dk.subject.application.entity.SubjectCategoryDTO
     */
    @PostMapping("/getCategoryListByPrimary")
    public Result<List<SubjectCategoryBO>> getCategoryListByPrimary(@Valid @RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.getCategoryListByPrimary.subjectCategoryDTO:{}", JSONObject.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertToSubjectCategoryBO(subjectCategoryDTO);
            List<SubjectCategoryBO> result = subjectCategoryDomainService.getCategoryListByPrimary(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("新增题目分类失败~，原因：{}", e.getMessage());
            return Result.fail(null);
        }
    }
}
