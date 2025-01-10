package com.dk.subject.domain.service;

import com.dk.subject.domain.bo.SubjectCategoryBO;
import com.dk.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> getPrimaryCategoryList();

    List<SubjectCategoryBO> getCategoryListByPrimary(SubjectCategoryBO subjectCategoryBO);

    Boolean update(SubjectCategoryBO subjectCategoryBO);

    Boolean remove(SubjectCategoryBO subjectCategoryBO);
}
