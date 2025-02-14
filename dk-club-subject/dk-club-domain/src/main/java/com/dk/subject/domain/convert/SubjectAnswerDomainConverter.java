package com.dk.subject.domain.convert;

import com.dk.subject.domain.bo.SubjectAnswerBO;
import com.dk.subject.infra.basic.entity.SubjectJudge;
import com.dk.subject.infra.basic.entity.SubjectMultiple;
import com.dk.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目标签Domain转换类
 */
@Mapper
public interface SubjectAnswerDomainConverter {

    SubjectAnswerDomainConverter INSTANCE = Mappers.getMapper(SubjectAnswerDomainConverter.class);

    List<SubjectAnswerBO> convertSubjectJudgeListToSubjectAnswerBOList(List<SubjectJudge> subjectJudgeList);

    List<SubjectAnswerBO> convertSubjectListToSubjectAnswerBOList(List<SubjectMultiple> subjectMultipleList);

    List<SubjectAnswerBO> convertRadioListToSubjectAnswerBOList(List<SubjectRadio> subjectRadioList);
}
