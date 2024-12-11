package com.dk.subject.application.controller;

import com.dk.subject.infra.basic.entity.SubjectCategory;
import com.dk.subject.infra.basic.service.SubjectCategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
* @author lxb
* @since 2024-12-10
*/
@RestController
@RequestMapping("/subject-category")
public class SubjectCategoryController {

    @Autowired
    private SubjectCategoryService subjectCategoryService;

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/selectOne")
    public SubjectCategory getSubjectCategory(@RequestParam("id") Integer id){
     SubjectCategory subjectCategoryOne = subjectCategoryService.getSubjectCategory( id);
     return  subjectCategoryOne;
   }

    @GetMapping("/listAll")
    public List<SubjectCategory> getAllSubjectCategory(){
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.getAllSubjectCategory();
        return  subjectCategoryList;
    }

    @PostMapping("/add")
    public Object add(@Valid @RequestBody SubjectCategory subjectCategory) {
        subjectCategoryService.add( subjectCategory);
        return  null;
    }

    @PutMapping("/update")
    public int update(@Valid @RequestBody SubjectCategory subjectCategory) {
        int num = subjectCategoryService.modify( subjectCategory);
        return  num;
    }


    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
         subjectCategoryService.remove(ids);
        return null;
    }
}
