package com.dk.subject.domain.convert;

import com.dk.subject.domain.entity.SubjectCategoryBO;
import com.dk.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectCategoryBOConverter {

    SubjectCategoryBOConverter INSTANCE = Mappers.getMapper(SubjectCategoryBOConverter.class);

    SubjectCategory convertToSubjectCategory(SubjectCategoryBO subjectCategoryBO);
}
