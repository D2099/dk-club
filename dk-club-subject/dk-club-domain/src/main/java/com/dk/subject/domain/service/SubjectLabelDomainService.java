package com.dk.subject.domain.service;

import com.dk.subject.domain.bo.SubjectLabelBO;

public interface SubjectLabelDomainService {
    Boolean add(SubjectLabelBO subjectLabelBO);

    Boolean delete(SubjectLabelBO subjectLabelBO);
}
