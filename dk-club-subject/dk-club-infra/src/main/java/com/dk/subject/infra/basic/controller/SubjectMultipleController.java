package com.dk.subject.infra.basic.controller;

import com.dk.subject.infra.basic.entity.SubjectMultiple;
import com.dk.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 多选题信息表 接口控制器
 * @author DEMOKING
 * @since 2025-01-14
 */
@RestController
@RequestMapping("/subject-multiple")
public class SubjectMultipleController {

    @Autowired
    private SubjectMultipleService subjectMultipleService;

    /**
     * 通过主键ID查询一个多选题信息表
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public SubjectMultiple getSubjectMultiple(@RequestParam("id") Long id) {
        SubjectMultiple subjectMultipleOne = subjectMultipleService.getSubjectMultiple(id);
        return subjectMultipleOne;
    }

    /**
     * 查询全部多选题信息表
     */
    @GetMapping("/listAll")
    public List<SubjectMultiple> getAllSubjectMultiple() {
        List<SubjectMultiple> subjectMultipleList = subjectMultipleService.getAllSubjectMultiple();
        return subjectMultipleList;
    }

    /**
     * 新增多选题信息表
     * @param subjectMultiple com.dk.subject.infra.basic.entity.SubjectMultiple
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody SubjectMultiple subjectMultiple) {
        subjectMultipleService.add(subjectMultiple);
        return null;
    }

    /**
     * 更新多选题信息表
     * @param  subjectMultiple com.dk.subject.infra.basic.entity.SubjectMultiple
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody SubjectMultiple subjectMultiple) {
        int num = subjectMultipleService.modify(subjectMultiple);
        return num;
    }

    /**
     * 通过主键ID删除多选题信息表
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        subjectMultipleService.remove(ids);
        return null;
    }
}
