package com.dk.subject.infra.basic.service.impl;

import com.dk.subject.infra.basic.entity.SubjectJudge;
import com.dk.subject.infra.basic.mapper.SubjectJudgeMapper;
import com.dk.subject.infra.basic.service.SubjectJudgeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 判断题 服务实现类
 * @author DEMOKING
 * @since 2025-01-14
 */
@Service
public class SubjectJudgeServiceImpl extends ServiceImpl<SubjectJudgeMapper, SubjectJudge> implements SubjectJudgeService {

    @Autowired
    SubjectJudgeMapper subjectJudgeMapper;

    @Override
    public SubjectJudge getSubjectJudge(Long id) {
        return subjectJudgeMapper.selectById(id);
    }

    @Override
    public List<SubjectJudge> getAllSubjectJudge() {
        return subjectJudgeMapper.selectList(null);
    }

    @Override
    public void add(SubjectJudge subjectJudge) {
        subjectJudgeMapper.insert(subjectJudge);
    }

    @Override
    public int modify(SubjectJudge subjectJudge) {
        // 乐观锁更新
        // SubjectJudge currentSubjectJudge = subjectJudgeMapper.selectById(subjectJudge.getId());
        // subjectJudge.setVersion(currentSubjectJudge.getVersion());
        return subjectJudgeMapper.updateById(subjectJudge);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                subjectJudgeMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

    @Override
    public List<SubjectJudge> getSubjectJudgeListBySubjectId(Long subjectId) {
        return subjectJudgeMapper.querySubjectJudgeListBySubjectId(subjectId);
    }

}


