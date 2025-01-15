package com.dk.subject.domain.handler.subject;

import com.dk.subject.common.enums.SubjectTypeEnum;
import com.dk.subject.domain.bo.SubjectInfoBO;
import com.dk.subject.infra.basic.entity.SubjectMultiple;
import com.dk.subject.infra.basic.service.SubjectMultipleService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 多选题处理策略实现
 */
@Component
public class SubjectMultipleTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectTypeEnum getSubjectType() {
        return SubjectTypeEnum.MULTIPLE;
    }

    @Override
    public boolean add(SubjectInfoBO subjectInfoBO) {
        Preconditions.checkNotNull(subjectInfoBO.getOptionList(), "题目答案不能为空~");
        List<SubjectMultiple> subjectMultipleList = subjectInfoBO.getOptionList().stream()
                .map(option -> new SubjectMultiple()
                        .setSubjectId(subjectInfoBO.getId())
                        .setOptionType(option.getOptionType())
                        .setOptionContent(option.getOptionContent())
                        .setIsCorrect(option.getIsCorrect()))
                .toList();
        return subjectMultipleService.saveBatch(subjectMultipleList);
    }
}
