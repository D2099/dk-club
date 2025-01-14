package com.dk.subject.infra.basic.service.impl;

import com.dk.subject.infra.basic.entity.SubjectInfo;
import com.dk.subject.infra.basic.mapper.SubjectInfoMapper;
import com.dk.subject.infra.basic.service.SubjectInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 题目信息表 服务实现类
 * @author DEMOKING
 * @since 2025-01-14
 */
@Service
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoMapper, SubjectInfo> implements SubjectInfoService {

    @Autowired
    SubjectInfoMapper subjectInfoMapper;

    @Override
    public SubjectInfo getSubjectInfo(Long id) {
        return subjectInfoMapper.selectById(id);
    }

    @Override
    public List<SubjectInfo> getAllSubjectInfo() {
        return subjectInfoMapper.selectList(null);
    }

    @Override
    public void add(SubjectInfo subjectInfo) {
        subjectInfoMapper.insert(subjectInfo);
    }

    @Override
    public int modify(SubjectInfo subjectInfo) {
        // 乐观锁更新
        // SubjectInfo currentSubjectInfo = subjectInfoMapper.selectById(subjectInfo.getId());
        // subjectInfo.setVersion(currentSubjectInfo.getVersion());
        return subjectInfoMapper.updateById(subjectInfo);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                subjectInfoMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

}


