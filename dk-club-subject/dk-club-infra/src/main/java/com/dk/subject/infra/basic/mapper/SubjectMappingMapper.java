package com.dk.subject.infra.basic.mapper;

import com.dk.subject.infra.basic.entity.SubjectMapping;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 题目分类关系表 Mapper接口
 * @author DEMOKING
 * @since 2025-01-14
 */
@Mapper
public interface SubjectMappingMapper extends BaseMapper<SubjectMapping> {
    List<Long> queryLabelIdList(SubjectMapping subjectMapping);
}
