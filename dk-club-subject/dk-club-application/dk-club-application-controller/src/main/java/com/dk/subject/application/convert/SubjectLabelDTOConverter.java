package com.dk.subject.application.convert;

import com.dk.subject.application.dto.SubjectLabelDTO;
import com.dk.subject.domain.bo.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目标签DTO转换类
 */
@Mapper
public interface SubjectLabelDTOConverter {

    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

    SubjectLabelBO convertToSubjectLabelBO(SubjectLabelDTO SubjectLabelDTO);

    SubjectLabelDTO convertToSubjectLabelDTO(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelDTO> convertToSubjectLabelDTOList(List<SubjectLabelBO> subjectLabelBOList);
}
