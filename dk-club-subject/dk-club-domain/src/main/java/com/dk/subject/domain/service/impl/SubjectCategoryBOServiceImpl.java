package com.dk.subject.domain.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dk.subject.domain.convert.SubjectCategoryBOConverter;
import com.dk.subject.domain.entity.SubjectCategoryBO;
import com.dk.subject.domain.service.SubjectCategoryBOService;
import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubjectCategoryBOServiceImpl implements SubjectCategoryBOService {

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
}
