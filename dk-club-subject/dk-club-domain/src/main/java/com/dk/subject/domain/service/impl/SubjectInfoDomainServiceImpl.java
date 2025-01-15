package com.dk.subject.domain.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dk.subject.domain.bo.SubjectInfoBO;
import com.dk.subject.domain.convert.SubjectInfoDomainConverter;
import com.dk.subject.domain.handler.subject.SubjectTypeHandler;
import com.dk.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.dk.subject.domain.service.SubjectInfoDomainService;
import com.dk.subject.infra.basic.entity.SubjectInfo;
import com.dk.subject.infra.basic.entity.SubjectMapping;
import com.dk.subject.infra.basic.service.SubjectInfoService;
import com.dk.subject.infra.basic.service.SubjectMappingService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Transactional
    @Override
    public Boolean add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.add.subjectInfoBO:{}", JSONObject.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoDomainConverter.INSTANCE.convertToSubjectInfo(subjectInfoBO);
        boolean subjectInfoSaveResult = subjectInfoService.save(subjectInfo);
        if (!subjectInfoSaveResult) {
            throw new RuntimeException("题目信息新增失败~");
        }
        subjectInfoBO.setId(subjectInfo.getId());
        SubjectTypeHandler subjectTypeHandler = subjectTypeHandlerFactory.getSubjectTypeHandler(subjectInfo.getSubjectType());
        boolean subjectTypeHandlerResult = subjectTypeHandler.add(subjectInfoBO);
        if (!subjectTypeHandlerResult) {
            throw new RuntimeException("题目答案新增失败~");
        }
        List<SubjectMapping> subjectMappingList = getCategoryLabelMappingList(subjectInfoBO);
        boolean subjectMappingSaveBatchResult = subjectMappingService.saveBatch(subjectMappingList);
        if (!subjectMappingSaveBatchResult) {
            throw new RuntimeException("题目分类标签关联失败~");
        }
        return true;
    }

    /**
     * 获取题目分类标签映射列表
     * @param subjectInfoBO
     * @return
     */
    private List<SubjectMapping> getCategoryLabelMappingList(SubjectInfoBO subjectInfoBO) {
        List<Long> categoryIds = subjectInfoBO.getCategoryIds();
        List<Long> labelIds = subjectInfoBO.getLabelIds();
        Preconditions.checkNotNull(categoryIds, "分类ID列表不能为空~");
        Preconditions.checkNotNull(labelIds, "标签ID列表不能为空~");
        List<SubjectMapping> subjectMappingList = new ArrayList<>();
        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping()
                        .setSubjectId(subjectInfoBO.getId())
                        .setCategoryId(categoryId)
                        .setLabelId(labelId);
                subjectMappingList.add(subjectMapping);
            });
        });
        return subjectMappingList;
    }
}
