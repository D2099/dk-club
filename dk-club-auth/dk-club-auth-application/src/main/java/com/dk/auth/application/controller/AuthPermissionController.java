package com.dk.auth.application.controller;

import com.dk.auth.infra.basic.entity.AuthPermission;
import com.dk.auth.infra.basic.service.AuthPermissionService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 权限表 接口控制器
 * @author DEMOKING
 * @since 2025-04-15
 */
@Slf4j
@RestController
@RequestMapping("/auth-permission")
public class AuthPermissionController {

    @Resource
    private AuthPermissionService authPermissionService;

    /**
     * 通过主键ID查询一个权限表
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public AuthPermission getAuthPermission(@RequestParam("id") Long id) {
        AuthPermission authPermissionOne = authPermissionService.getAuthPermission(id);
        return authPermissionOne;
    }

    /**
     * 查询全部权限表
     */
    @GetMapping("/listAll")
    public List<AuthPermission> getAllAuthPermission() {
        List<AuthPermission> authPermissionList = authPermissionService.getAllAuthPermission();
        return authPermissionList;
    }

    /**
     * 新增权限表
     * @param authPermission com.dk.auth.infra.basic.entity.AuthPermission
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody AuthPermission authPermission) {
        authPermissionService.add(authPermission);
        return null;
    }

    /**
     * 更新权限表
     * @param  authPermission com.dk.auth.infra.basic.entity.AuthPermission
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody AuthPermission authPermission) {
        int num = authPermissionService.modify(authPermission);
        return num;
    }

    /**
     * 通过主键ID删除权限表
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        authPermissionService.remove(ids);
        return null;
    }
}
