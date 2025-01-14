package com.dk.subject.domain.service;

import com.dk.subject.domain.bo.SubjectLabelBO;

import java.util.List;

public interface SubjectLabelDomainService {
    Boolean add(SubjectLabelBO subjectLabelBO);

    Boolean delete(SubjectLabelBO subjectLabelBO);

    Boolean update(SubjectLabelBO subjectLabelBO);

    /**
     * 根据分类ID获取标签列表
     * @param subjectLabelBO
     * @return
     */
    List<SubjectLabelBO> getLabelListByCategoryId(SubjectLabelBO subjectLabelBO);
}
