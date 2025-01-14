package com.dk.subject.domain.convert;

import com.dk.subject.domain.bo.SubjectLabelBO;
import com.dk.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目标签Domain转换类
 */
@Mapper
public interface SubjectLabelDomainConverter {

    SubjectLabelDomainConverter INSTANCE = Mappers.getMapper(SubjectLabelDomainConverter.class);

    SubjectLabel convertToSubjectLabel(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> convertToSubjectLabelBO(List<SubjectLabel> subjectLabelList);
}
