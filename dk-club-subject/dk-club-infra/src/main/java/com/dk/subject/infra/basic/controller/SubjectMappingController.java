package com.dk.subject.infra.basic.controller;

import com.dk.subject.infra.basic.entity.SubjectMapping;
import com.dk.subject.infra.basic.service.SubjectMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 题目分类关系表 接口控制器
 * @author DEMOKING
 * @since 2025-01-14
 */
@RestController
@RequestMapping("/subject-mapping")
public class SubjectMappingController {

    @Autowired
    private SubjectMappingService subjectMappingService;

    /**
     * 通过主键ID查询一个题目分类关系表
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public SubjectMapping getSubjectMapping(@RequestParam("id") Integer id) {
        SubjectMapping subjectMappingOne = subjectMappingService.getSubjectMapping(id);
        return subjectMappingOne;
    }

    /**
     * 查询全部题目分类关系表
     */
    @GetMapping("/listAll")
    public List<SubjectMapping> getAllSubjectMapping() {
        List<SubjectMapping> subjectMappingList = subjectMappingService.getAllSubjectMapping();
        return subjectMappingList;
    }

    /**
     * 新增题目分类关系表
     * @param subjectMapping com.dk.subject.infra.basic.entity.SubjectMapping
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody SubjectMapping subjectMapping) {
        subjectMappingService.add(subjectMapping);
        return null;
    }

    /**
     * 更新题目分类关系表
     * @param  subjectMapping com.dk.subject.infra.basic.entity.SubjectMapping
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody SubjectMapping subjectMapping) {
        int num = subjectMappingService.modify(subjectMapping);
        return num;
    }

    /**
     * 通过主键ID删除题目分类关系表
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        subjectMappingService.remove(ids);
        return null;
    }
}
