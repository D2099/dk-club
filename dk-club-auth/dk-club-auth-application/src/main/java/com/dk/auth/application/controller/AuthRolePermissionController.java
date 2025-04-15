package com.dk.auth.application.controller;

import com.dk.auth.infra.basic.entity.AuthRolePermission;
import com.dk.auth.infra.basic.service.AuthRolePermissionService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 角色权限关系表 接口控制器
 * @author DEMOKING
 * @since 2025-04-15
 */
@Slf4j
@RestController
@RequestMapping("/auth-role-permission")
public class AuthRolePermissionController {

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    /**
     * 通过主键ID查询一个角色权限关系表
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public AuthRolePermission getAuthRolePermission(@RequestParam("id") Long id) {
        AuthRolePermission authRolePermissionOne = authRolePermissionService.getAuthRolePermission(id);
        return authRolePermissionOne;
    }

    /**
     * 查询全部角色权限关系表
     */
    @GetMapping("/listAll")
    public List<AuthRolePermission> getAllAuthRolePermission() {
        List<AuthRolePermission> authRolePermissionList = authRolePermissionService.getAllAuthRolePermission();
        return authRolePermissionList;
    }

    /**
     * 新增角色权限关系表
     * @param authRolePermission com.dk.auth.infra.basic.entity.AuthRolePermission
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody AuthRolePermission authRolePermission) {
        authRolePermissionService.add(authRolePermission);
        return null;
    }

    /**
     * 更新角色权限关系表
     * @param  authRolePermission com.dk.auth.infra.basic.entity.AuthRolePermission
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody AuthRolePermission authRolePermission) {
        int num = authRolePermissionService.modify(authRolePermission);
        return num;
    }

    /**
     * 通过主键ID删除角色权限关系表
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        authRolePermissionService.remove(ids);
        return null;
    }
}
