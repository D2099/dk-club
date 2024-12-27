package com.dk.subject.application.convert;

import com.dk.subject.application.entity.SubjectCategoryDTO;
import com.dk.subject.domain.entity.SubjectCategoryBO;
import com.dk.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectCategoryDTOConverter {

    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBO convertToSubjectCategoryBO(SubjectCategoryDTO SubjectCategoryDTO);
}
