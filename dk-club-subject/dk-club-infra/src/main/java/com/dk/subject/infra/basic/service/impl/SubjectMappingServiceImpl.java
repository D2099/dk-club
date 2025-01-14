package com.dk.subject.infra.basic.service.impl;

import com.dk.subject.infra.basic.entity.SubjectMapping;
import com.dk.subject.infra.basic.mapper.SubjectMappingMapper;
import com.dk.subject.infra.basic.service.SubjectMappingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 题目分类关系表 服务实现类
 * @author DEMOKING
 * @since 2025-01-14
 */
@Service
public class SubjectMappingServiceImpl extends ServiceImpl<SubjectMappingMapper, SubjectMapping> implements SubjectMappingService {

    @Autowired
    SubjectMappingMapper subjectMappingMapper;

    @Override
    public SubjectMapping getSubjectMapping(Integer id) {
        return subjectMappingMapper.selectById(id);
    }

    @Override
    public List<SubjectMapping> getAllSubjectMapping() {
        return subjectMappingMapper.selectList(null);
    }

    @Override
    public void add(SubjectMapping subjectMapping) {
        subjectMappingMapper.insert(subjectMapping);
    }

    @Override
    public int modify(SubjectMapping subjectMapping) {
        // 乐观锁更新
        // SubjectMapping currentSubjectMapping = subjectMappingMapper.selectById(subjectMapping.getId());
        // subjectMapping.setVersion(currentSubjectMapping.getVersion());
        return subjectMappingMapper.updateById(subjectMapping);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                subjectMappingMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

}


