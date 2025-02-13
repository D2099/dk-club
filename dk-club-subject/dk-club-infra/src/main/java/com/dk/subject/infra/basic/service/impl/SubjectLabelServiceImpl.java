package com.dk.subject.infra.basic.service.impl;

import com.dk.subject.infra.basic.entity.SubjectLabel;
import com.dk.subject.infra.basic.mapper.SubjectLabelMapper;
import com.dk.subject.infra.basic.service.SubjectLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 题目标签表 服务实现类
 * @author DEMOKING
 * @since 2025-01-10
 */
@Service
public class SubjectLabelServiceImpl extends ServiceImpl<SubjectLabelMapper, SubjectLabel> implements SubjectLabelService {

    @Resource
    SubjectLabelMapper subjectLabelMapper;

    @Override
    public SubjectLabel getSubjectLabel(Long id) {
        return subjectLabelMapper.selectById(id);
    }

    @Override
    public List<SubjectLabel> getAllSubjectLabel() {
        return subjectLabelMapper.selectList(null);
    }

    @Override
    public int add(SubjectLabel subjectLabel) {
        return subjectLabelMapper.insert(subjectLabel);
    }

    @Override
    public int modify(SubjectLabel subjectLabel) {
        // 乐观锁更新
        SubjectLabel currentSubjectLabel = subjectLabelMapper.selectById(subjectLabel.getId());
        // subjectLabel.setVersion(currentSubjectLabel.getVersion());
        return subjectLabelMapper.updateById(subjectLabel);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                subjectLabelMapper.deleteBatchIds(Arrays.asList(array));
            }
        }
    }

    @Override
    public long count(SubjectLabel subjectLabel) {
        return subjectLabelMapper.count(subjectLabel);
    }

    @Override
    public List<SubjectLabel> getSubjectLabelList(List<Long> labelIds) {
        return subjectLabelMapper.querySubjectLabelList(labelIds);
    }

    @Override
    public List<SubjectLabel> getLabelListByIds(List<Long> labelIdList) {
        return subjectLabelMapper.querySubjectLabelList(labelIdList);
    }

}


