package com.dk.subject.infra.basic.service;

import com.dk.subject.infra.basic.entity.SubjectBrief;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-01-14
 */
public interface SubjectBriefService extends IService<SubjectBrief> {

    /**
     * 简答题根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    SubjectBrief getSubjectBrief(Long id);

    /**
     * 简答题获取全部详情
     * @param
     * @return
     */
    List<SubjectBrief> getAllSubjectBrief();

    /**
     * 简答题新增
     * @param subjectBrief 根据需要进行传值
     * @return
     */
    void add(SubjectBrief subjectBrief);

    /**
     * 简答题修改
     * @param subjectBrief 根据需要进行传值
     * @return
     */
    int modify(SubjectBrief subjectBrief);

    /**
     * 简答题删除
     * @param ids
     * @return
     */
    void remove(String ids);
}


