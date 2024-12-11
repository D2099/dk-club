package com.dk.subject.application.controller;

import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.service.SubjectCategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 类别接口控制器
* @author lxb
* @since 2024-12-10
*/
@RestController
@RequestMapping("/subject-category")
public class SubjectCategoryController {

    @Autowired
    private SubjectCategoryService subjectCategoryService;

    /**
     * 通过主键ID查询一个类别
     * @param id 主键ID
     * @return 类别对象
     */
    @GetMapping("/selectOne")
    public SubjectCategory getSubjectCategory(@RequestParam("id") Integer id){
     SubjectCategory subjectCategoryOne = subjectCategoryService.getSubjectCategory( id);
     return  subjectCategoryOne;
   }

    /**
     * 查询全部类别
     * @return 类别对象集合
     */
    @GetMapping("/listAll")
    public List<SubjectCategory> getAllSubjectCategory(){
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.getAllSubjectCategory();
        return  subjectCategoryList;
    }

    /**
     * 新增类别
     * @param subjectCategory com.dk.subject.infra.basic.entity.SubjectCategory
     * @return 暂无
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody SubjectCategory subjectCategory) {
        subjectCategoryService.add( subjectCategory);
        return null;
    }

    /**
     * 更新类别
     * @param subjectCategory com.dk.subject.infra.basic.entity.SubjectCategory
     * @return 暂无
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody SubjectCategory subjectCategory) {
        int num = subjectCategoryService.modify( subjectCategory);
        return  num;
    }

    /**
     * 通过主键ID删除类别
     *
     * @param ids 主键ID（可以多个英文逗号隔开）
     * @return 暂无
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
         subjectCategoryService.remove(ids);
        return null;
    }
}
