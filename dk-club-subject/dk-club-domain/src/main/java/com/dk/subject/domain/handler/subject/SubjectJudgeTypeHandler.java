package com.dk.subject.domain.handler.subject;

import com.dk.subject.common.enums.SubjectTypeEnum;
import com.dk.subject.domain.bo.SubjectInfoBO;
import com.dk.subject.infra.basic.entity.SubjectJudge;
import com.dk.subject.infra.basic.service.SubjectJudgeService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 判断题处理策略实现
 */
@Component
public class SubjectJudgeTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectTypeEnum getSubjectType() {
        return SubjectTypeEnum.JUDGE;
    }

    @Override
    public boolean add(SubjectInfoBO subjectInfoBO) {
        Preconditions.checkNotNull(subjectInfoBO.getOptionList(), "题目答案不能为空~");
        List<SubjectJudge> subjectJudgeList = subjectInfoBO.getOptionList().stream()
                .map(option -> new SubjectJudge()
                        .setSubjectId(subjectInfoBO.getId())
                        .setIsCorrect(option.getIsCorrect()))
                .toList();
        return subjectJudgeService.saveBatch(subjectJudgeList);
    }
}
