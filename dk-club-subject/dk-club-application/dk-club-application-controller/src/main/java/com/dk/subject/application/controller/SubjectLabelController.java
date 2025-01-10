package com.dk.subject.application.controller;

import com.dk.subject.common.entity.Result;
import com.dk.subject.infra.basic.entity.SubjectLabel;
import com.dk.subject.infra.basic.service.SubjectLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 题目标签表 接口控制器
 * @author DEMOKING
 * @since 2025-01-10
 */
@RestController
@RequestMapping("/subject-label")
public class SubjectLabelController {

    @Autowired
    private SubjectLabelService subjectLabelService;

    /**
     * 通过主键ID查询一个题目标签表
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public SubjectLabel getSubjectLabel(@RequestParam("id") Integer id) {
        SubjectLabel subjectLabelOne = subjectLabelService.getSubjectLabel(id);
        return subjectLabelOne;
    }

    /**
     * 查询全部题目标签表
     */
    @GetMapping("/listAll")
    public List<SubjectLabel> getAllSubjectLabel() {
        List<SubjectLabel> subjectLabelList = subjectLabelService.getAllSubjectLabel();
        return subjectLabelList;
    }

    /**
     * 新增题目标签表
     * @param subjectLabel com.dk.subject.infra.basic.entity.SubjectLabel
     */
    @PostMapping("/add")
    public Result<Boolean> add(@Valid @RequestBody SubjectLabel subjectLabel) {

        return null;
    }

    /**
     * 更新题目标签表
     * @param  subjectLabel com.dk.subject.infra.basic.entity.SubjectLabel
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody SubjectLabel subjectLabel) {
        int num = subjectLabelService.modify(subjectLabel);
        return num;
    }

    /**
     * 通过主键ID删除题目标签表
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        subjectLabelService.remove(ids);
        return null;
    }
}
