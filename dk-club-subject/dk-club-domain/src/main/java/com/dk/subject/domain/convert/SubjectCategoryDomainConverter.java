package com.dk.subject.domain.convert;

import com.dk.subject.domain.bo.SubjectCategoryBO;
import com.dk.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目分类Domain转换类
 */
@Mapper
public interface SubjectCategoryDomainConverter {

    SubjectCategoryDomainConverter INSTANCE = Mappers.getMapper(SubjectCategoryDomainConverter.class);

    SubjectCategory convertToSubjectCategory(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> convertToSubjectCategoryList(List<SubjectCategory> subjectCategory);
}
