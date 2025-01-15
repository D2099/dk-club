package com.dk.subject.domain.handler.subject;

import com.dk.subject.common.enums.SubjectTypeEnum;
import com.dk.subject.domain.bo.SubjectInfoBO;
import com.dk.subject.infra.basic.entity.SubjectRadio;
import com.dk.subject.infra.basic.service.SubjectRadioService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 单选题处理策略实现
 */
@Component
public class SubjectRadioTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectTypeEnum getSubjectType() {
        return SubjectTypeEnum.RADIO;
    }

    @Override
    public boolean add(SubjectInfoBO subjectInfoBO) {
        Preconditions.checkNotNull(subjectInfoBO.getOptionList(), "题目答案不能为空~");
        List<SubjectRadio> subjectRadioList = subjectInfoBO.getOptionList().stream()
                .map(option -> new SubjectRadio()
                        .setSubjectId(subjectInfoBO.getId())
                        .setOptionType(option.getOptionType())
                        .setOptionContent(option.getOptionContent())
                        .setIsCorrect(option.getIsCorrect()))
                .toList();
        return subjectRadioService.saveBatch(subjectRadioList);
    }
}
