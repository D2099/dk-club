package com.dk.subject.domain.handler.subject;

import com.dk.subject.common.enums.SubjectTypeEnum;
import com.dk.subject.common.enums.YesOrNoEnum;
import com.dk.subject.domain.bo.SubjectInfoBO;
import com.dk.subject.domain.bo.SubjectOptionBO;
import com.dk.subject.domain.convert.SubjectAnswerDomainConverter;
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

    @Override
    public SubjectOptionBO queryAnswer(Long subjectId) {
        List<SubjectJudge> subjectJudgeList = subjectJudgeService.getSubjectJudgeListBySubjectId(subjectId);
        SubjectJudge correctSubjectJudge = subjectJudgeList.stream().filter(sj -> sj.getIsCorrect().equals(YesOrNoEnum.YES.getCode())).findAny().orElse(null);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        if (correctSubjectJudge != null) {
            subjectOptionBO.setSubjectAnswer(correctSubjectJudge.getId().toString());
        }
        subjectOptionBO.setOptionList(
                SubjectAnswerDomainConverter.INSTANCE.convertSubjectJudgeListToSubjectAnswerBOList(subjectJudgeList));
        return subjectOptionBO;
    }
}
