package com.dk.subject.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.dk.subject.application.convert.SubjectLabelDTOConverter;
import com.dk.subject.application.dto.SubjectLabelDTO;
import com.dk.subject.common.entity.Result;
import com.dk.subject.domain.bo.SubjectLabelBO;
import com.dk.subject.domain.service.SubjectLabelDomainService;
import com.dk.subject.infra.basic.entity.SubjectLabel;
import com.dk.subject.infra.basic.service.SubjectLabelService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/subject-label")
public class SubjectLabelController {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

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
     * @param subjectLabelDTO com.dk.subject.application.dto.SubjectLabelDTO
     */
    @PostMapping("/add")
    public Result<Boolean> add(@Valid @RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.subjectLabelDTO:{}", JSONObject.toJSONString(subjectLabelDTO));
            }
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertToSubjectLabelBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.add(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("新增题目标签失败~，原因：{}", e.getMessage());
            return Result.fail("新增题目标签失败~");
        }
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
     * @param subjectLabelDTO com.dk.subject.application.dto.SubjectLabelDTO
     */
    @PostMapping(value = "/delete")
    public Result<Boolean> remove(@Valid @RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.subjectLabelDTO:{}", JSONObject.toJSONString(subjectLabelDTO));
            }
            // ====== 参数校验 ======
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签ID不能为空~");
            // ====== 参数校验 ======
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertToSubjectLabelBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.delete(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("移除题目标签失败~，原因：{}", e.getMessage());
            return Result.fail("移除题目标签失败~");
        }
    }
}
