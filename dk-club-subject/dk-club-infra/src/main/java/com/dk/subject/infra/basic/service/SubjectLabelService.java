package com.dk.subject.infra.basic.service;

import com.dk.subject.infra.basic.entity.SubjectLabel;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-01-10
 */
public interface SubjectLabelService extends IService<SubjectLabel> {

    /**
     * 题目标签表根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    SubjectLabel getSubjectLabel(Integer id);

    /**
     * 题目标签表获取全部详情
     * @param
     * @return
     */
    List<SubjectLabel> getAllSubjectLabel();

    /**
     * 题目标签表新增
     *
     * @param subjectLabel 根据需要进行传值
     * @return
     */
    int add(SubjectLabel subjectLabel);

    /**
     * 题目标签表修改
     * @param subjectLabel 根据需要进行传值
     * @return
     */
    int modify(SubjectLabel subjectLabel);

    /**
     * 题目标签表删除
     * @param ids
     * @return
     */
    void remove(String ids);

    /**
     * 按条件查询题目标签表数量
     * @param subjectLabel
     * @return
     */
    long count(SubjectLabel subjectLabel);
}


