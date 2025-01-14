package com.dk.subject.infra.basic.controller;

import com.dk.subject.infra.basic.entity.SubjectJudge;
import com.dk.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 判断题 接口控制器
 * @author DEMOKING
 * @since 2025-01-14
 */
@RestController
@RequestMapping("/subject-judge")
public class SubjectJudgeController {

    @Autowired
    private SubjectJudgeService subjectJudgeService;

    /**
     * 通过主键ID查询一个判断题
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public SubjectJudge getSubjectJudge(@RequestParam("id") Long id) {
        SubjectJudge subjectJudgeOne = subjectJudgeService.getSubjectJudge(id);
        return subjectJudgeOne;
    }

    /**
     * 查询全部判断题
     */
    @GetMapping("/listAll")
    public List<SubjectJudge> getAllSubjectJudge() {
        List<SubjectJudge> subjectJudgeList = subjectJudgeService.getAllSubjectJudge();
        return subjectJudgeList;
    }

    /**
     * 新增判断题
     * @param subjectJudge com.dk.subject.infra.basic.entity.SubjectJudge
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody SubjectJudge subjectJudge) {
        subjectJudgeService.add(subjectJudge);
        return null;
    }

    /**
     * 更新判断题
     * @param  subjectJudge com.dk.subject.infra.basic.entity.SubjectJudge
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody SubjectJudge subjectJudge) {
        int num = subjectJudgeService.modify(subjectJudge);
        return num;
    }

    /**
     * 通过主键ID删除判断题
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        subjectJudgeService.remove(ids);
        return null;
    }
}
