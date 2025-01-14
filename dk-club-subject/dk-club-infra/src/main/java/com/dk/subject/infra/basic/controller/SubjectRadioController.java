package com.dk.subject.infra.basic.controller;

import com.dk.subject.infra.basic.entity.SubjectRadio;
import com.dk.subject.infra.basic.service.SubjectRadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 单选题信息表 接口控制器
 * @author DEMOKING
 * @since 2025-01-14
 */
@RestController
@RequestMapping("/subject-radio")
public class SubjectRadioController {

    @Autowired
    private SubjectRadioService subjectRadioService;

    /**
     * 通过主键ID查询一个单选题信息表
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public SubjectRadio getSubjectRadio(@RequestParam("id") Long id) {
        SubjectRadio subjectRadioOne = subjectRadioService.getSubjectRadio(id);
        return subjectRadioOne;
    }

    /**
     * 查询全部单选题信息表
     */
    @GetMapping("/listAll")
    public List<SubjectRadio> getAllSubjectRadio() {
        List<SubjectRadio> subjectRadioList = subjectRadioService.getAllSubjectRadio();
        return subjectRadioList;
    }

    /**
     * 新增单选题信息表
     * @param subjectRadio com.dk.subject.infra.basic.entity.SubjectRadio
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody SubjectRadio subjectRadio) {
        subjectRadioService.add(subjectRadio);
        return null;
    }

    /**
     * 更新单选题信息表
     * @param  subjectRadio com.dk.subject.infra.basic.entity.SubjectRadio
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody SubjectRadio subjectRadio) {
        int num = subjectRadioService.modify(subjectRadio);
        return num;
    }

    /**
     * 通过主键ID删除单选题信息表
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        subjectRadioService.remove(ids);
        return null;
    }
}
