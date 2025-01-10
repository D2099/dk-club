package com.dk.subject.infra.basic.service.impl;

import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.mapper.SubjectCategoryMapper;
import com.dk.subject.infra.basic.service.SubjectCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 题目分类 服务实现类
 * @author DEMOKING
 * @since 2024-12-12
 */
@Service
public class SubjectCategoryServiceImpl extends ServiceImpl<SubjectCategoryMapper, SubjectCategory> implements SubjectCategoryService {

    @Resource
    SubjectCategoryMapper subjectCategoryMapper;

    @Override
    public SubjectCategory getSubjectCategory(Integer id) {
        return subjectCategoryMapper.selectById(id);
    }

    @Override
    public List<SubjectCategory> getAllSubjectCategory() {
        return subjectCategoryMapper.selectList(null);
    }

    @Override
    public void insert(SubjectCategory subjectCategory) {
        subjectCategoryMapper.insert(subjectCategory);
    }

    @Override
    public int modify(SubjectCategory subjectCategory) {
        // 乐观锁更新
        SubjectCategory currentSubjectCategory = subjectCategoryMapper.selectById(subjectCategory.getId());
        // subjectCategory.setVersion(currentSubjectCategory.getVersion());
        return subjectCategoryMapper.updateById(subjectCategory);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                subjectCategoryMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

    @Override
    public List<SubjectCategory> getPrimaryCategory(SubjectCategory subjectCategory) {
        return subjectCategoryMapper.queryPrimaryCategory(subjectCategory);
    }

    @Override
    public List<SubjectCategory> getCategoryListByPrimary(SubjectCategory subjectCategory) {
        return subjectCategoryMapper.queryCategoryListByPrimary(subjectCategory);
    }

}


