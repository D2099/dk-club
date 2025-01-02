package com.dk.subject.domain.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dk.subject.domain.convert.SubjectCategoryBOConverter;
import com.dk.subject.domain.bo.SubjectCategoryBO;
import com.dk.subject.domain.service.SubjectCategoryDomainService;
import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryBOServiceImpl.add.subjectCategoryBO : {}", JSONObject.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE.convertToSubjectCategory(subjectCategoryBO);
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> getPrimaryCategoryList() {
        SubjectCategory subjectCategory = new SubjectCategory()
                .setParentId(0L);
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.getPrimaryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryBOConverter.INSTANCE.convertToSubjectCategoryList(subjectCategoryList);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.getPrimaryCategoryList.boList: {}", JSONObject.toJSONString(boList));
        }
        return boList;
    }
}
