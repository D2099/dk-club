package com.dk.subject.domain.handler.subject;

import com.dk.subject.common.enums.SubjectTypeEnum;
import com.dk.subject.domain.bo.SubjectInfoBO;
import com.dk.subject.domain.bo.SubjectOptionBO;
import com.dk.subject.infra.basic.entity.SubjectBrief;
import com.dk.subject.infra.basic.service.SubjectBriefService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 判断题处理策略实现
 */
@Component
public class SubjectBriefTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectTypeEnum getSubjectType() {
        return SubjectTypeEnum.BRIEF;
    }

    @Override
    public boolean add(SubjectInfoBO subjectInfoBO) {
        SubjectBrief subjectBrief = new SubjectBrief()
                .setSubjectId(subjectInfoBO.getId())
                .setSubjectAnswer(subjectInfoBO.getSubjectAnswer());
        return subjectBriefService.save(subjectBrief);
    }

    @Override
    public SubjectOptionBO queryAnswer(Long subjectId) {
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        SubjectBrief subjectBrief = subjectBriefService.getSubjectAnswerBySubjectId(subjectId);
        subjectOptionBO.setSubjectAnswer(subjectBrief.getSubjectAnswer());
        return subjectOptionBO;
    }
}
