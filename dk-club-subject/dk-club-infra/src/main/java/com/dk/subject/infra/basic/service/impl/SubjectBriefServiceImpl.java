package com.dk.subject.infra.basic.service.impl;

import com.dk.subject.infra.basic.entity.SubjectBrief;
import com.dk.subject.infra.basic.mapper.SubjectBriefMapper;
import com.dk.subject.infra.basic.service.SubjectBriefService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 简答题 服务实现类
 * @author DEMOKING
 * @since 2025-01-14
 */
@Service
public class SubjectBriefServiceImpl extends ServiceImpl<SubjectBriefMapper, SubjectBrief> implements SubjectBriefService {

    @Autowired
    SubjectBriefMapper subjectBriefMapper;

    @Override
    public SubjectBrief getSubjectBrief(Long id) {
        return subjectBriefMapper.selectById(id);
    }

    @Override
    public List<SubjectBrief> getAllSubjectBrief() {
        return subjectBriefMapper.selectList(null);
    }

    @Override
    public void add(SubjectBrief subjectBrief) {
        subjectBriefMapper.insert(subjectBrief);
    }

    @Override
    public int modify(SubjectBrief subjectBrief) {
        // 乐观锁更新
        // SubjectBrief currentSubjectBrief = subjectBriefMapper.selectById(subjectBrief.getId());
        // subjectBrief.setVersion(currentSubjectBrief.getVersion());
        return subjectBriefMapper.updateById(subjectBrief);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                subjectBriefMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

    @Override
    public SubjectBrief getSubjectAnswerBySubjectId(Long subjectId) {
        return subjectBriefMapper.querySubjectAnswerBySubjectId(subjectId);
    }

}


