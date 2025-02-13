package com.dk.subject.domain.bo;

import com.dk.subject.common.entity.PageInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 题目答案 BO类
 * @author DEMOKING
 * @date 2025-01-14
 */
@Data
@Accessors(chain = true)
public class SubjectOptionBO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 题目答案
     */
    private String subjectAnswer;
    /**
     * 题目答案
     */
    private List<SubjectAnswerBO> optionList;
}
