package com.dk.auth.application.controller;

import com.dk.auth.infra.basic.entity.AuthRole;
import com.dk.auth.infra.basic.service.AuthRoleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 角色表 接口控制器
 * @author DEMOKING
 * @since 2025-04-14
 */
@Slf4j
@RestController
@RequestMapping("/auth-role")
public class AuthRoleController {

    @Resource
    private AuthRoleService authRoleService;

    /**
     * 通过主键ID查询一个角色表
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public AuthRole getAuthRole(@RequestParam("id") Long id) {
        AuthRole authRoleOne = authRoleService.getAuthRole(id);
        return authRoleOne;
    }

    /**
     * 查询全部角色表
     */
    @GetMapping("/listAll")
    public List<AuthRole> getAllAuthRole() {
        List<AuthRole> authRoleList = authRoleService.getAllAuthRole();
        return authRoleList;
    }

    /**
     * 新增角色表
     * @param authRole com.dk.auth.infra.basic.entity.AuthRole
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody AuthRole authRole) {
        authRoleService.add(authRole);
        return null;
    }

    /**
     * 更新角色表
     * @param  authRole com.dk.auth.infra.basic.entity.AuthRole
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody AuthRole authRole) {
        int num = authRoleService.modify(authRole);
        return num;
    }

    /**
     * 通过主键ID删除角色表
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        authRoleService.remove(ids);
        return null;
    }
}
