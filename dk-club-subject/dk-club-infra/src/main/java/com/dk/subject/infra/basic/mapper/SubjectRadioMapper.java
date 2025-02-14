package com.dk.subject.infra.basic.mapper;

import com.dk.subject.infra.basic.entity.SubjectRadio;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 单选题信息表 Mapper接口
 * @author DEMOKING
 * @since 2025-01-14
 */
@Mapper
public interface SubjectRadioMapper extends BaseMapper<SubjectRadio> {
    List<SubjectRadio> querySubjectRadioListBySubjectId(Long subjectId);
}
