package com.dk.subject.application.controller;

import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 题目分类 接口控制器
 * @author DEMOKING
 * @since 2024-12-12
 */
@RestController
@RequestMapping("/subject-category")
public class SubjectCategoryController {

    @Autowired
    private SubjectCategoryService subjectCategoryService;

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
     * 新增题目分类
     * @param subjectCategory com.dk.subject.infra.basic.entity.SubjectCategory
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody SubjectCategory subjectCategory) {
        subjectCategoryService.add(subjectCategory);
        return null;
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
