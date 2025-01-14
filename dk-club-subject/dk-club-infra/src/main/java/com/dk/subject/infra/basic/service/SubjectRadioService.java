package com.dk.subject.infra.basic.service;

import com.dk.subject.infra.basic.entity.SubjectRadio;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-01-14
 */
public interface SubjectRadioService extends IService<SubjectRadio> {

    /**
     * 单选题信息表根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    SubjectRadio getSubjectRadio(Long id);

    /**
     * 单选题信息表获取全部详情
     * @param
     * @return
     */
    List<SubjectRadio> getAllSubjectRadio();

    /**
     * 单选题信息表新增
     * @param subjectRadio 根据需要进行传值
     * @return
     */
    void add(SubjectRadio subjectRadio);

    /**
     * 单选题信息表修改
     * @param subjectRadio 根据需要进行传值
     * @return
     */
    int modify(SubjectRadio subjectRadio);

    /**
     * 单选题信息表删除
     * @param ids
     * @return
     */
    void remove(String ids);
}


