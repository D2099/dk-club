package com.dk.subject.domain.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dk.subject.common.enums.DeleteFlagEnum;
import com.dk.subject.domain.convert.SubjectCategoryDomainConverter;
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
        SubjectCategory subjectCategory = SubjectCategoryDomainConverter.INSTANCE.convertToSubjectCategory(subjectCategoryBO);
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> getPrimaryCategoryList() {
        SubjectCategory subjectCategory = new SubjectCategory()
                .setParentId(0L);
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.getPrimaryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryDomainConverter.INSTANCE.convertToSubjectCategoryList(subjectCategoryList);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.getPrimaryCategoryList.boList: {}", JSONObject.toJSONString(boList));
        }
        return boList;
    }

    @Override
    public List<SubjectCategoryBO> getCategoryListByPrimary(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryDomainConverter.INSTANCE.convertToSubjectCategory(subjectCategoryBO);
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.getCategoryListByPrimary(subjectCategory);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.getCategoryListByPrimary.subjectCategoryList:{}", JSONObject.toJSONString(subjectCategoryList));
        }
        List<SubjectCategoryBO> boList = SubjectCategoryDomainConverter.INSTANCE.convertToSubjectCategoryList(subjectCategoryList);
        return boList;
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryDomainConverter.INSTANCE.convertToSubjectCategory(subjectCategoryBO);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.update.subjectCategory:{}", JSONObject.toJSONString(subjectCategory));
        }
        return subjectCategoryService.updateById(subjectCategory);
    }

    @Override
    public Boolean remove(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryDomainConverter.INSTANCE.convertToSubjectCategory(subjectCategoryBO);
        subjectCategory.setDelFlag(DeleteFlagEnum.DELETE.getCode());
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.remove.subjectCategory:{}", JSONObject.toJSONString(subjectCategory));
        }
        return subjectCategoryService.updateById(subjectCategory);
    }
}
