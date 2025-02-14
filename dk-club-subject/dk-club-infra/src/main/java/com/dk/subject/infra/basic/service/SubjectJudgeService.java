package com.dk.subject.infra.basic.service;

import com.dk.subject.infra.basic.entity.SubjectJudge;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-01-14
 */
public interface SubjectJudgeService extends IService<SubjectJudge> {

    /**
     * 判断题根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    SubjectJudge getSubjectJudge(Long id);

    /**
     * 判断题获取全部详情
     * @param
     * @return
     */
    List<SubjectJudge> getAllSubjectJudge();

    /**
     * 判断题新增
     * @param subjectJudge 根据需要进行传值
     * @return
     */
    void add(SubjectJudge subjectJudge);

    /**
     * 判断题修改
     * @param subjectJudge 根据需要进行传值
     * @return
     */
    int modify(SubjectJudge subjectJudge);

    /**
     * 判断题删除
     * @param ids
     * @return
     */
    void remove(String ids);

    /**
     * 通过题目ID获取判断题列表
     * @param subjectId
     * @return
     */
    List<SubjectJudge> getSubjectJudgeListBySubjectId(Long subjectId);
}


