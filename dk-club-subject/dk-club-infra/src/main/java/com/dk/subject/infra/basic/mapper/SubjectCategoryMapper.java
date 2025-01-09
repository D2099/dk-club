package com.dk.subject.infra.basic.mapper;

import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 题目分类 Mapper接口
 * @author DEMOKING
 * @since 2024-12-12
 */
@Mapper
public interface SubjectCategoryMapper extends BaseMapper<SubjectCategory> {
    List<SubjectCategory> queryPrimaryCategory(SubjectCategory subjectCategory);

    List<SubjectCategory> queryCategoryListByPrimary(SubjectCategory subjectCategory);
}
