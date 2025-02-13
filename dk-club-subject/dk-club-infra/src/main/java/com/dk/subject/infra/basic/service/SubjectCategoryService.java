package com.dk.subject.infra.basic.service;

import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2024-12-12
 */
public interface SubjectCategoryService extends IService<SubjectCategory> {

    /**
     * 题目分类根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    SubjectCategory getSubjectCategory(Long id);

    /**
     * 题目分类获取全部详情
     * @param
     * @return
     */
    List<SubjectCategory> getAllSubjectCategory();

    /**
     * 题目分类新增
     * @param subjectCategory 根据需要进行传值
     * @return
     */
    void insert(SubjectCategory subjectCategory);

    /**
     * 题目分类修改
     * @param subjectCategory 根据需要进行传值
     * @return
     */
    int modify(SubjectCategory subjectCategory);

    /**
     * 题目分类删除
     * @param ids
     * @return
     */
    void remove(String ids);

    /**
     * 获取所有主分类列表
     * @param subjectCategory
     * @return
     */
    List<SubjectCategory> getPrimaryCategory(SubjectCategory subjectCategory);

    /**
     * 获取主分类下的所有子分类列表
     * @param subjectCategory
     * @return
     */
    List<SubjectCategory> getCategoryListByPrimary(SubjectCategory subjectCategory);

    /**
     * 通过分类ID列表获取对应分类信息
     * @param categoryIdList
     * @return
     */
    List<SubjectCategory> getCategoryListByIds(List<Long> categoryIdList);
}


