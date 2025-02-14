package com.dk.subject.infra.basic.service.impl;

import com.dk.subject.infra.basic.entity.SubjectMultiple;
import com.dk.subject.infra.basic.mapper.SubjectMultipleMapper;
import com.dk.subject.infra.basic.service.SubjectMultipleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 多选题信息表 服务实现类
 * @author DEMOKING
 * @since 2025-01-14
 */
@Service
public class SubjectMultipleServiceImpl extends ServiceImpl<SubjectMultipleMapper, SubjectMultiple> implements SubjectMultipleService {

    @Autowired
    SubjectMultipleMapper subjectMultipleMapper;

    @Override
    public SubjectMultiple getSubjectMultiple(Long id) {
        return subjectMultipleMapper.selectById(id);
    }

    @Override
    public List<SubjectMultiple> getAllSubjectMultiple() {
        return subjectMultipleMapper.selectList(null);
    }

    @Override
    public void add(SubjectMultiple subjectMultiple) {
        subjectMultipleMapper.insert(subjectMultiple);
    }

    @Override
    public int modify(SubjectMultiple subjectMultiple) {
        // 乐观锁更新
        // SubjectMultiple currentSubjectMultiple = subjectMultipleMapper.selectById(subjectMultiple.getId());
        // subjectMultiple.setVersion(currentSubjectMultiple.getVersion());
        return subjectMultipleMapper.updateById(subjectMultiple);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                subjectMultipleMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

    @Override
    public List<SubjectMultiple> getSubjectMultipleListBySubjectId(Long subjectId) {
        return subjectMultipleMapper.querySubjectMultipleListBySubjectId(subjectId);
    }

}


