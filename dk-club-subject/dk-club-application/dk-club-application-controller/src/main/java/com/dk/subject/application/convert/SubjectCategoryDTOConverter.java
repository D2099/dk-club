package com.dk.subject.application.convert;

import com.dk.subject.application.dto.SubjectCategoryDTO;
import com.dk.subject.domain.bo.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectCategoryDTOConverter {

    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBO convertToSubjectCategoryBO(SubjectCategoryDTO SubjectCategoryDTO);
}
