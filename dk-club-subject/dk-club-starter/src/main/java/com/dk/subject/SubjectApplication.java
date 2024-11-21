package com.dk.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * 刷题项目启动类
 */
@SpringBootApplication(scanBasePackages = "com.dk.subject")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class, args);
    }
}
