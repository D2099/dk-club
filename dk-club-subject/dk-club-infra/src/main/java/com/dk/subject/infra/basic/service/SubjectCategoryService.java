package com.dk.subject.infra.basic.service;

import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
* @author lxb
* @since 2024-12-10
*/
public interface SubjectCategoryService extends IService<SubjectCategory> {

    /**  
    * SubjectCategory详情  
    * @param
    * @return  
    */  
    SubjectCategory getSubjectCategory( Integer id);

    /**  
    * SubjectCategory详情  
    * @param
    * @return  
    */  
    List<SubjectCategory> getAllSubjectCategory();

    /**  
    * SubjectCategory新增  
    * @param subjectCategory 根据需要进行传值
    * @return  
    */  
    void add(SubjectCategory subjectCategory);

    /**  
    * SubjectCategory修改  
    * @param subjectCategory 根据需要进行传值
    * @return  
    */  
    int modify(SubjectCategory subjectCategory);

    /**  
    * SubjectCategory删除
    * @param ids
    * @return  
    */  
    void remove(String ids);
}


