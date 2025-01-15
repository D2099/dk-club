package com.dk.subject.domain.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 判断题 BO类
 * @author DEMOKING
 * @date 2025-01-14
 */
@Data
@Accessors(chain = true)
public class SubjectAnswerBO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 选项类型
     */
    private Integer optionType;
    /**
     * 选项内容
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;
}
