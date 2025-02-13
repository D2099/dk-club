package com.dk.subject.infra.basic.mapper;

import com.dk.subject.common.entity.PageInfo;
import com.dk.subject.infra.basic.entity.SubjectInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 题目信息表 Mapper接口
 * @author DEMOKING
 * @since 2025-01-14
 */
@Mapper
public interface SubjectInfoMapper extends BaseMapper<SubjectInfo> {
    Integer countConditions(@Param("subjectInfo") SubjectInfo subjectInfo,
                            @Param("categoryId") Long categoryId,
                            @Param("labelId") Long labelId);

    List<SubjectInfo> querySubjectList(@Param("subjectInfo") SubjectInfo subjectInfo,
                                       @Param("pageInfo") PageInfo pageInfo,
                                       @Param("categoryId") Long categoryId,
                                       @Param("labelId") Long labelId);
}
