package com.dk.subject.infra.basic.mapper;

import com.dk.subject.infra.basic.entity.SubjectInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目信息表 Mapper接口
 * @author DEMOKING
 * @since 2025-01-14
 */
@Mapper
public interface SubjectInfoMapper extends BaseMapper<SubjectInfo> {
}
