package com.dk.subject.application.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 判断题 DTO类
 * @author DEMOKING
 * @date 2025-01-14
 */
@Data
@Accessors(chain = true)
@TableName("subject_judge")
public class SubjectAnswerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 选项类型
     */
    private Long optionType;
    /**
     * 选项内容
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;
}
