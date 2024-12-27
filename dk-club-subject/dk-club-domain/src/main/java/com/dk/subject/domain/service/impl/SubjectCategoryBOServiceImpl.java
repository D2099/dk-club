package com.dk.subject.domain.service.impl;

import com.dk.subject.domain.convert.SubjectCategoryBOConverter;
import com.dk.subject.domain.entity.SubjectCategoryBO;
import com.dk.subject.domain.service.SubjectCategoryBOService;
import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SubjectCategoryBOServiceImpl implements SubjectCategoryBOService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE.convertToSubjectCategory(subjectCategoryBO);
        subjectCategoryService.insert(subjectCategory);
    }
}
