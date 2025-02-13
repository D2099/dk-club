package com.dk.subject.infra.basic.mapper;

import com.dk.subject.infra.basic.entity.SubjectBrief;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 简答题 Mapper接口
 * @author DEMOKING
 * @since 2025-01-14
 */
@Mapper
public interface SubjectBriefMapper extends BaseMapper<SubjectBrief> {
    SubjectBrief querySubjectAnswerBySubjectId(Long subjectId);
}
