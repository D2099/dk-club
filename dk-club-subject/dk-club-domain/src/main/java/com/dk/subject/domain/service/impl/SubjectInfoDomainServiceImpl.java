package com.dk.subject.domain.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dk.subject.common.enums.CategoryTypeEnum;
import com.dk.subject.common.enums.DeleteFlagEnum;
import com.dk.subject.domain.bo.SubjectCategoryBO;
import com.dk.subject.domain.bo.SubjectInfoBO;
import com.dk.subject.domain.convert.SubjectCategoryDomainConverter;
import com.dk.subject.domain.convert.SubjectInfoDomainConverter;
import com.dk.subject.domain.service.SubjectCategoryDomainService;
import com.dk.subject.domain.service.SubjectInfoDomainService;
import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.entity.SubjectInfo;
import com.dk.subject.infra.basic.service.SubjectCategoryService;
import com.dk.subject.infra.basic.service.SubjectInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Override
    public Boolean add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.add.subjectInfoBO:{}", JSONObject.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoDomainConverter.INSTANCE.convertToSubjectInfo(subjectInfoBO);
        boolean subjectInfoSaveResult = subjectInfoService.save(subjectInfo);

        return null;
    }
}
