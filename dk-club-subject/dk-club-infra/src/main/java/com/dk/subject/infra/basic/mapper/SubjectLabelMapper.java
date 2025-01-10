package com.dk.subject.infra.basic.mapper;

import com.dk.subject.infra.basic.entity.SubjectLabel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目标签表 Mapper接口
 * @author DEMOKING
 * @since 2025-01-10
 */
@Mapper
public interface SubjectLabelMapper extends BaseMapper<SubjectLabel> {
}
