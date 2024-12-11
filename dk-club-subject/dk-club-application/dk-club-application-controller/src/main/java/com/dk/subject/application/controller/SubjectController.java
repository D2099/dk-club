package com.dk.subject.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口控制器
 */
@RestController()
@RequestMapping("/subject")
public class SubjectController {

    /**
     * 测试接口连通性
     * @return
     */
    @GetMapping("/test")
    public String test() {
        return "hello word";
    }
}
