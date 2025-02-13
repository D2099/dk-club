package com.dk.subject.domain.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dk.subject.common.entity.PageInfo;
import com.dk.subject.common.entity.PageResult;
import com.dk.subject.domain.bo.SubjectInfoBO;
import com.dk.subject.domain.bo.SubjectOptionBO;
import com.dk.subject.domain.convert.SubjectInfoDomainConverter;
import com.dk.subject.domain.handler.subject.SubjectTypeHandler;
import com.dk.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.dk.subject.domain.service.SubjectInfoDomainService;
import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.entity.SubjectInfo;
import com.dk.subject.infra.basic.entity.SubjectLabel;
import com.dk.subject.infra.basic.entity.SubjectMapping;
import com.dk.subject.infra.basic.service.SubjectCategoryService;
import com.dk.subject.infra.basic.service.SubjectInfoService;
import com.dk.subject.infra.basic.service.SubjectLabelService;
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
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectCategoryService subjectCategoryService;

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
            // TODO
            throw new RuntimeException("题目信息新增失败~");
        }
        subjectInfoBO.setId(subjectInfo.getId());
        SubjectTypeHandler subjectTypeHandler = subjectTypeHandlerFactory.getSubjectTypeHandler(subjectInfo.getSubjectType());
        boolean subjectTypeHandlerResult = subjectTypeHandler.add(subjectInfoBO);
        if (!subjectTypeHandlerResult) {
            // TODO
            throw new RuntimeException("题目答案新增失败~");
        }
        List<SubjectMapping> subjectMappingList = getCategoryLabelMappingList(subjectInfoBO);
        boolean subjectMappingSaveBatchResult = subjectMappingService.saveBatch(subjectMappingList);
        if (!subjectMappingSaveBatchResult) {
            // TODO
            throw new RuntimeException("题目分类标签关联失败~");
        }
        return true;
    }

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.getSubjectList.subjectInfoBO:{}", JSONObject.toJSONString(subjectInfoBO));
        }
        PageInfo pageInfo = new PageInfo(subjectInfoBO.getCurrentPage(), subjectInfoBO.getPageSize());
        SubjectInfo subjectInfo = SubjectInfoDomainConverter.INSTANCE.convertToSubjectInfo(subjectInfoBO);
        Integer count = subjectInfoService.countConditions(
                subjectInfo, subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId());
        if (count <= 0) {
            return new PageResult<>();
        }
        List<SubjectInfo> subjectInfoList = subjectInfoService.getSubjectList(
                subjectInfo, pageInfo, subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId());
        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoDomainConverter.INSTANCE.convertToSubjectInfoBOList(subjectInfoList);
        PageResult<SubjectInfoBO> page = new PageResult<>();
        page.setCurrentPage(subjectInfoBO.getCurrentPage());
        page.setPageSize(subjectInfoBO.getPageSize());
        page.setRecords(subjectInfoBOList);
        page.setTotal(count);
        return page;
    }

    @Override
    public SubjectInfoBO getSubjectDetail(SubjectInfoBO subjectInfoBO) {
        // 获取题目信息
        SubjectInfo subjectInfo = subjectInfoService.getSubjectInfo(subjectInfoBO.getId());
        if (subjectInfo == null) {
            return null;
        }
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getSubjectTypeHandler(subjectInfo.getSubjectType());
        SubjectOptionBO subjectOptionBO = handler.queryAnswer(subjectInfo.getId());
        SubjectInfoBO subjectInfoBOResult =
                SubjectInfoDomainConverter.INSTANCE.convertInfoOptionToSubjectInfoBO(subjectInfo, subjectOptionBO);
        // 获取题目关联
        List<SubjectMapping> subjectMappingList = subjectMappingService.getSubjectMappingBySubjectId(subjectInfoBO.getId());
        // 获取题目分类标签信息
        List<Long> categoryIds = subjectMappingList.stream().map(SubjectMapping::getCategoryId).distinct().toList();
        List<Long> labelIds = subjectMappingList.stream().map(SubjectMapping::getLabelId).distinct().toList();
        // 设置题目分类标签名称
        if (!categoryIds.isEmpty()) {
            List<SubjectCategory> categoryList = subjectCategoryService.getCategoryListByIds(categoryIds);
            List<String> categoryNames = categoryList.stream().map(SubjectCategory::getCategoryName).toList();
            subjectInfoBOResult.setCategoryNames(categoryNames);
        }
        if (!labelIds.isEmpty()) {
            List<SubjectLabel> labelList = subjectLabelService.getLabelListByIds(labelIds);
            List<String> labelNames = labelList.stream().map(SubjectLabel::getLabelName).toList();
            subjectInfoBOResult.setLabelNames(labelNames);
        }

        return subjectInfoBOResult;
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
