package com.dk.subject.application.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dk.subject.common.entity.PageInfo;
import com.dk.subject.common.entity.PageResult;
import com.dk.subject.domain.bo.SubjectAnswerBO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目信息表 DTO类
 * @author DEMOKING
 * @date 2025-01-14
 */
@Data
@Accessors(chain = true)
public class SubjectInfoDTO extends PageInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 题目名称
     */
    private String subjectName;
    /**
     * 题目难度
     */
    private Integer subjectDifficult;
    /**
     * 出题人名
     */
    private String settleName;
    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;
    /**
     * 题目答案
     */
    private String subjectAnswer;
    /**
     * 题目分类
     */
    private List<Long> categoryIds;
    /**
     * 标题分类
     */
    private List<Long> labelIds;
    /**
     * 题目答案
     */
    private List<SubjectAnswerBO> optionList;
    /**
     * 分类ID
     */
    private Long categoryId;
    /**
     * 标签ID
     */
    private Long labelId;
}
