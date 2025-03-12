package com.dk.subject.domain.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dk.subject.common.enums.CategoryTypeEnum;
import com.dk.subject.common.enums.DeleteFlagEnum;
import com.dk.subject.domain.bo.SubjectLabelBO;
import com.dk.subject.domain.convert.SubjectLabelDomainConverter;
import com.dk.subject.domain.service.SubjectLabelDomainService;
import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.entity.SubjectLabel;
import com.dk.subject.infra.basic.entity.SubjectMapping;
import com.dk.subject.infra.basic.service.SubjectCategoryService;
import com.dk.subject.infra.basic.service.SubjectLabelService;
import com.dk.subject.infra.basic.service.SubjectMappingService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService SubjectLabelService;

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelDomainConverter.INSTANCE.convertToSubjectLabel(subjectLabelBO);
        subjectLabel.setDelFlag(DeleteFlagEnum.UN_DELETE.getCode());
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.add.subjectLabel:{}", JSONObject.toJSONString(subjectLabel));
        }
        return SubjectLabelService.save(subjectLabel);
    }

    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelDomainConverter.INSTANCE.convertToSubjectLabel(subjectLabelBO);
        subjectLabel.setDelFlag(DeleteFlagEnum.DELETE.getCode());
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.delete.subjectLabel:{}", JSONObject.toJSONString(subjectLabel));
        }
        return SubjectLabelService.removeById(subjectLabel);
    }

    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelDomainConverter.INSTANCE.convertToSubjectLabel(subjectLabelBO);
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.update.subjectLabel:{}", JSONObject.toJSONString(subjectLabel));
        }
        return SubjectLabelService.updateById(subjectLabel);
    }

    @Override
    public List<SubjectLabelBO> getLabelListByCategoryId(SubjectLabelBO subjectLabelBO) {
        Long categoryId = subjectLabelBO.getCategoryId();
        SubjectCategory subjectCategory = subjectCategoryService.getSubjectCategory(categoryId);
        if (subjectCategory != null) {
            if (CategoryTypeEnum.PRIMARY_CATEGORY.getCode().equals(subjectCategory.getCategoryType())) {
                List<SubjectLabel> subjectLabelList = subjectLabelService.getLabelListByCategoryId(subjectCategory.getId());
                List<SubjectLabelBO> subjectLabelBOList = SubjectLabelDomainConverter.INSTANCE.convertToSubjectLabelBO(subjectLabelList);
                return subjectLabelBOList;
            }
        }
        SubjectMapping subjectMapping = new SubjectMapping()
                .setCategoryId(categoryId)
                .setDelFlag(DeleteFlagEnum.UN_DELETE.getCode());
        List<Long> labelIds = subjectMappingService.getLabelIdList(subjectMapping);
        if (labelIds.isEmpty()) {
            return List.of();
        }
        List<SubjectLabel> subjectLabelList = SubjectLabelService.getSubjectLabelList(labelIds);
        List<SubjectLabelBO> subjectLabelBOList = SubjectLabelDomainConverter.INSTANCE.convertToSubjectLabelBO(subjectLabelList);
        return subjectLabelBOList;
    }
}
