package com.dk.subject.domain.convert;

import com.dk.subject.domain.bo.SubjectCategoryBO;
import com.dk.subject.domain.bo.SubjectInfoBO;
import com.dk.subject.domain.bo.SubjectOptionBO;
import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目分类Domain转换类
 */
@Mapper
public interface SubjectInfoDomainConverter {

    SubjectInfoDomainConverter INSTANCE = Mappers.getMapper(SubjectInfoDomainConverter.class);

    SubjectInfo convertToSubjectInfo(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoBO> convertToSubjectInfoBOList(List<SubjectInfo> subjectInfoList);

    SubjectInfoBO convertInfoOptionToSubjectInfoBO(SubjectInfo subjectInfo, SubjectOptionBO subjectOptionBO);
}
