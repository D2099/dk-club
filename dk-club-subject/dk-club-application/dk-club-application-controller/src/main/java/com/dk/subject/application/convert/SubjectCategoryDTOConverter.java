package com.dk.subject.application.convert;

import com.dk.subject.application.dto.SubjectCategoryDTO;
import com.dk.subject.domain.bo.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目分类DTO转换类
 */
@Mapper
public interface SubjectCategoryDTOConverter {

    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBO convertToSubjectCategoryBO(SubjectCategoryDTO SubjectCategoryDTO);

    List<SubjectCategoryDTO> convertToSubjectCategoryBOList(List<SubjectCategoryBO> SubjectCategoryDTOList);
}
