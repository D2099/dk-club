package com.dk.subject.infra.basic.service.impl;

import com.dk.subject.infra.basic.entity.SubjectRadio;
import com.dk.subject.infra.basic.mapper.SubjectRadioMapper;
import com.dk.subject.infra.basic.service.SubjectRadioService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 单选题信息表 服务实现类
 * @author DEMOKING
 * @since 2025-01-14
 */
@Service
public class SubjectRadioServiceImpl extends ServiceImpl<SubjectRadioMapper, SubjectRadio> implements SubjectRadioService {

    @Autowired
    SubjectRadioMapper subjectRadioMapper;

    @Override
    public SubjectRadio getSubjectRadio(Long id) {
        return subjectRadioMapper.selectById(id);
    }

    @Override
    public List<SubjectRadio> getAllSubjectRadio() {
        return subjectRadioMapper.selectList(null);
    }

    @Override
    public void add(SubjectRadio subjectRadio) {
        subjectRadioMapper.insert(subjectRadio);
    }

    @Override
    public int modify(SubjectRadio subjectRadio) {
        // 乐观锁更新
        // SubjectRadio currentSubjectRadio = subjectRadioMapper.selectById(subjectRadio.getId());
        // subjectRadio.setVersion(currentSubjectRadio.getVersion());
        return subjectRadioMapper.updateById(subjectRadio);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                subjectRadioMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

    @Override
    public List<SubjectRadio> getSubjectRadioListBySubjectId(Long subjectId) {
        return subjectRadioMapper.querySubjectRadioListBySubjectId(subjectId);
    }

}


