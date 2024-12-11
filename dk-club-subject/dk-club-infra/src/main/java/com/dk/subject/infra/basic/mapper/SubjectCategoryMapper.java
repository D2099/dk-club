package com.dk.subject.infra.basic.mapper;

import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 题目分类 Mapper 接口
 * </p>
 *
 * @author lxb
 * @since 2024-12-10
 */
@Mapper
public interface SubjectCategoryMapper extends BaseMapper<SubjectCategory> {

}
