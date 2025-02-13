package com.dk.subject.domain.handler.subject;

import com.dk.subject.common.enums.SubjectTypeEnum;
import com.dk.subject.domain.bo.SubjectInfoBO;
import com.dk.subject.domain.bo.SubjectOptionBO;

/**
 * 题目类型处理接口
 */
public interface SubjectTypeHandler {

    /**
     * 获取题目类型枚举
     * @return
     */
    SubjectTypeEnum getSubjectType();

    /**
     * 处理题目信息
     * @param subjectInfoBO
     * @return
     */
    boolean add(SubjectInfoBO subjectInfoBO);

    SubjectOptionBO queryAnswer(Long subjectId);
}
