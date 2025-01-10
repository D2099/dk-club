package com.dk.subject.domain.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dk.subject.domain.bo.SubjectLabelBO;
import com.dk.subject.domain.convert.SubjectLabelDomainConverter;
import com.dk.subject.domain.service.SubjectLabelDomainService;
import com.dk.subject.infra.basic.entity.SubjectLabel;
import com.dk.subject.infra.basic.service.SubjectLabelService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService SubjectLabelService;

    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelDomainConverter.INSTANCE.convertToSubjectLabel(subjectLabelBO);
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.add.subjectLabel:{}", JSONObject.toJSONString(subjectLabel));
        }
        return SubjectLabelService.save(subjectLabel);
    }
}
