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
    SubjectLabel getSubjectLabel(Long id);

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

    /**
     * 根据ID获取标签列表
     * @param labelIds
     * @return
     */
    List<SubjectLabel> getSubjectLabelList(List<Long> labelIds);

    /**
     * 获取标签ID列表中对应的标签信息
     * @param labelIdList
     * @return
     */
    List<SubjectLabel> getLabelListByIds(List<Long> labelIdList);

    /**
     * 通过分类ID获取标签ID列表
     * @param categoryId
     * @return
     */
    List<SubjectLabel> getLabelListByCategoryId(Long categoryId);
}


