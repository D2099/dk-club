package com.dk.subject.infra.basic.service;

import com.dk.subject.infra.basic.entity.SubjectMultiple;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-01-14
 */
public interface SubjectMultipleService extends IService<SubjectMultiple> {

    /**
     * 多选题信息表根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    SubjectMultiple getSubjectMultiple(Long id);

    /**
     * 多选题信息表获取全部详情
     * @param
     * @return
     */
    List<SubjectMultiple> getAllSubjectMultiple();

    /**
     * 多选题信息表新增
     * @param subjectMultiple 根据需要进行传值
     * @return
     */
    void add(SubjectMultiple subjectMultiple);

    /**
     * 多选题信息表修改
     * @param subjectMultiple 根据需要进行传值
     * @return
     */
    int modify(SubjectMultiple subjectMultiple);

    /**
     * 多选题信息表删除
     * @param ids
     * @return
     */
    void remove(String ids);
}


