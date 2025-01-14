package com.dk.subject.application.controller;

import com.dk.subject.infra.basic.entity.SubjectInfo;
import com.dk.subject.infra.basic.service.SubjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 题目信息表 接口控制器
 * @author DEMOKING
 * @since 2025-01-14
 */
@RestController
@RequestMapping("/subject-info")
public class SubjectInfoController {

    @Autowired
    private SubjectInfoService subjectInfoService;

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
     * 新增题目信息表
     * @param subjectInfo com.dk.subject.infra.basic.entity.SubjectInfo
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody SubjectInfo subjectInfo) {
        subjectInfoService.add(subjectInfo);
        return null;
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
}
