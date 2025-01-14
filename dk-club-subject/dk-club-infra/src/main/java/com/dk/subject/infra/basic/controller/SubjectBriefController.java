package com.dk.subject.infra.basic.controller;

import com.dk.subject.infra.basic.entity.SubjectBrief;
import com.dk.subject.infra.basic.service.SubjectBriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 简答题 接口控制器
 * @author DEMOKING
 * @since 2025-01-14
 */
@RestController
@RequestMapping("/subject-brief")
public class SubjectBriefController {

    @Autowired
    private SubjectBriefService subjectBriefService;

    /**
     * 通过主键ID查询一个简答题
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public SubjectBrief getSubjectBrief(@RequestParam("id") Long id) {
        SubjectBrief subjectBriefOne = subjectBriefService.getSubjectBrief(id);
        return subjectBriefOne;
    }

    /**
     * 查询全部简答题
     */
    @GetMapping("/listAll")
    public List<SubjectBrief> getAllSubjectBrief() {
        List<SubjectBrief> subjectBriefList = subjectBriefService.getAllSubjectBrief();
        return subjectBriefList;
    }

    /**
     * 新增简答题
     * @param subjectBrief com.dk.subject.infra.basic.entity.SubjectBrief
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody SubjectBrief subjectBrief) {
        subjectBriefService.add(subjectBrief);
        return null;
    }

    /**
     * 更新简答题
     * @param  subjectBrief com.dk.subject.infra.basic.entity.SubjectBrief
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody SubjectBrief subjectBrief) {
        int num = subjectBriefService.modify(subjectBrief);
        return num;
    }

    /**
     * 通过主键ID删除简答题
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        subjectBriefService.remove(ids);
        return null;
    }
}
