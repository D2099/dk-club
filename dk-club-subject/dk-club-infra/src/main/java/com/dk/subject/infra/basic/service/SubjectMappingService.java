package com.dk.subject.infra.basic.service;

import com.dk.subject.infra.basic.entity.SubjectMapping;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-01-14
 */
public interface SubjectMappingService extends IService<SubjectMapping> {

    /**
     * 题目分类关系表根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    SubjectMapping getSubjectMapping(Integer id);

    /**
     * 题目分类关系表获取全部详情
     * @param
     * @return
     */
    List<SubjectMapping> getAllSubjectMapping();

    /**
     * 题目分类关系表新增
     * @param subjectMapping 根据需要进行传值
     * @return
     */
    void add(SubjectMapping subjectMapping);

    /**
     * 题目分类关系表修改
     * @param subjectMapping 根据需要进行传值
     * @return
     */
    int modify(SubjectMapping subjectMapping);

    /**
     * 题目分类关系表删除
     * @param ids
     * @return
     */
    void remove(String ids);
}


