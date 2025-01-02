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
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SubjectCategoryService subjectCategoryService;

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 通过主键ID查询一个题目分类
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public SubjectCategory getSubjectCategory(@RequestParam("id") Integer id) {
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
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(Boolean.TRUE);
        } catch (Exception e) {
            log.error("新增题目分类失败~，原因：{}", e.getMessage());
            return Result.fail(Boolean.FALSE);
        }
    }

    /**
     * 更新题目分类
     * @param  subjectCategory com.dk.subject.infra.basic.entity.SubjectCategory
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody SubjectCategory subjectCategory) {
        int num = subjectCategoryService.modify(subjectCategory);
        return num;
    }

    /**
     * 通过主键ID删除题目分类
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        subjectCategoryService.remove(ids);
        return null;
    }
}
