package com.dk.subject.domain.service;

import com.dk.subject.common.entity.PageResult;
import com.dk.subject.domain.bo.SubjectInfoBO;

public interface SubjectInfoDomainService {

    Boolean add(SubjectInfoBO subjectInfoBO);

    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    SubjectInfoBO getSubjectDetail(SubjectInfoBO subjectInfoBO);
}
