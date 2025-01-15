package com.dk.subject.application.convert;

import com.dk.subject.application.dto.SubjectCategoryDTO;
import com.dk.subject.application.dto.SubjectInfoDTO;
import com.dk.subject.domain.bo.SubjectCategoryBO;
import com.dk.subject.domain.bo.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目信息DTO转换类
 */
@Mapper
public interface SubjectInfoDTOConverter {

    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);

    SubjectInfoBO convertToSubjectInfoBO(SubjectInfoDTO subjectInfoDTO);
}
