package com.dk.subject.infra.basic.service;

import com.dk.subject.common.entity.PageInfo;
import com.dk.subject.infra.basic.entity.SubjectInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-01-14
 */
public interface SubjectInfoService extends IService<SubjectInfo> {

    /**
     * 题目信息表根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    SubjectInfo getSubjectInfo(Long id);

    /**
     * 题目信息表获取全部详情
     * @param
     * @return
     */
    List<SubjectInfo> getAllSubjectInfo();

    /**
     * 题目信息表新增
     * @param subjectInfo 根据需要进行传值
     * @return
     */
    void add(SubjectInfo subjectInfo);

    /**
     * 题目信息表修改
     * @param subjectInfo 根据需要进行传值
     * @return
     */
    int modify(SubjectInfo subjectInfo);

    /**
     * 题目信息表删除
     * @param ids
     * @return
     */
    void remove(String ids);

    Integer countConditions(SubjectInfo subjectInfo, Long categoryId, Long labelId);

    List<SubjectInfo> getSubjectList(SubjectInfo subjectInfo, PageInfo pageInfo, Long categoryId, Long labelId);
}


