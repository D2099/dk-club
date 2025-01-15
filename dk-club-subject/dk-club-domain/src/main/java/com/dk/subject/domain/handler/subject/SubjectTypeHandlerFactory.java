package com.dk.subject.domain.handler.subject;

import com.dk.subject.common.enums.SubjectTypeEnum;
import com.dk.subject.domain.bo.SubjectInfoBO;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 题目类型策略工厂
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {

    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerList;

    private Map<SubjectTypeEnum, SubjectTypeHandler> subjectTypeHandlerMap = new HashMap<>();

    public SubjectTypeHandler getSubjectTypeHandler(int subjectType) {
        SubjectTypeEnum subjectTypeEnum = SubjectTypeEnum.getByCode(subjectType);
        return subjectTypeHandlerMap.get(subjectTypeEnum);
    }

    @Override
    public void afterPropertiesSet() {
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerList) {
            subjectTypeHandlerMap.put(subjectTypeHandler.getSubjectType(), subjectTypeHandler);
        }
    }
}
