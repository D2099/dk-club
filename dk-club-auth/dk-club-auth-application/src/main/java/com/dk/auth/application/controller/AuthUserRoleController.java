package com.dk.auth.application.controller;

import com.dk.auth.infra.basic.entity.AuthUserRole;
import com.dk.auth.infra.basic.service.AuthUserRoleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 用户角色关系表 接口控制器
 * @author DEMOKING
 * @since 2025-04-15
 */
@Slf4j
@RestController
@RequestMapping("/auth-user-role")
public class AuthUserRoleController {

    @Resource
    private AuthUserRoleService authUserRoleService;

    /**
     * 通过主键ID查询一个用户角色关系表
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public AuthUserRole getAuthUserRole(@RequestParam("id") Long id) {
        AuthUserRole authUserRoleOne = authUserRoleService.getAuthUserRole(id);
        return authUserRoleOne;
    }

    /**
     * 查询全部用户角色关系表
     */
    @GetMapping("/listAll")
    public List<AuthUserRole> getAllAuthUserRole() {
        List<AuthUserRole> authUserRoleList = authUserRoleService.getAllAuthUserRole();
        return authUserRoleList;
    }

    /**
     * 新增用户角色关系表
     * @param authUserRole com.dk.auth.infra.basic.entity.AuthUserRole
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody AuthUserRole authUserRole) {
        authUserRoleService.add(authUserRole);
        return null;
    }

    /**
     * 更新用户角色关系表
     * @param  authUserRole com.dk.auth.infra.basic.entity.AuthUserRole
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody AuthUserRole authUserRole) {
        int num = authUserRoleService.modify(authUserRole);
        return num;
    }

    /**
     * 通过主键ID删除用户角色关系表
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        authUserRoleService.remove(ids);
        return null;
    }
}
