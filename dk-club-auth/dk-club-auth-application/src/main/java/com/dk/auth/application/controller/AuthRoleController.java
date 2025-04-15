package com.dk.auth.application.controller;

import com.dk.auth.application.convert.AuthRoleDTOConverter;
import com.dk.auth.application.dto.AuthRoleDto;
import com.dk.auth.common.entity.Result;
import com.dk.auth.domain.bo.AuthRoleBo;
import com.dk.auth.domain.service.AuthRoleDomainService;
import com.dk.auth.infra.basic.entity.AuthRole;
import com.dk.auth.infra.basic.service.AuthRoleService;
import com.google.common.base.Preconditions;
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

    @Resource
    private AuthRoleDomainService authRoleDomainService;

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
     * @param authRole com.dk.auth.application.dto.AuthRoleDto
     */
    @PostMapping("/add")
    public Result<Boolean> add(@Valid @RequestBody AuthRoleDto authRole) {
        if (log.isInfoEnabled()) {
            log.info(".AuthRoleController.add.authRole: {}", authRole);
        }
        try {
            Preconditions.checkNotNull(authRole.getRoleName(), "角色名称不能为空~");
            Preconditions.checkNotNull(authRole.getRoleKey(), "角色标识不能为空~");
            AuthRoleBo authRoleBo = AuthRoleDTOConverter.INSTANCE.convertAuthRoleBo(authRole);
            boolean result = authRoleDomainService.add(authRoleBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("新增用户角色失败，原因：{}", e.getMessage());
            return Result.fail("新增用户角色失败~");
        }
    }

    /**
     * 更新角色信息
     * @param  authRole com.dk.auth.application.dto.AuthRoleDto
     */
    @PostMapping("/update")
    public Result<Boolean> update(@Valid @RequestBody AuthRoleDto authRole) {
        if (log.isInfoEnabled()) {
            log.info(".AuthRoleController.update.authRole: {}", authRole);
        }
        try {
            Preconditions.checkNotNull(authRole.getId(), "ID不能为空~");
            Preconditions.checkNotNull(authRole.getRoleName(), "角色名称不能为空~");
            Preconditions.checkNotNull(authRole.getRoleKey(), "角色标识不能为空~");
            AuthRoleBo authRoleBo = AuthRoleDTOConverter.INSTANCE.convertAuthRoleBo(authRole);
            boolean result = authRoleDomainService.update(authRoleBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("更新用户角色信息失败，原因：{}", e.getMessage());
            return Result.fail("更新用户角色信息失败~");
        }
    }

    /**
     * 删除角色信息
     * @param  authRole com.dk.auth.application.dto.AuthRoleDto
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@Valid @RequestBody AuthRoleDto authRole) {
        if (log.isInfoEnabled()) {
            log.info(".AuthRoleController.delete.authRole: {}", authRole);
        }
        try {
            Preconditions.checkNotNull(authRole.getId(), "ID不能为空~");
            AuthRoleBo authRoleBo = AuthRoleDTOConverter.INSTANCE.convertAuthRoleBo(authRole);
            boolean result = authRoleDomainService.delete(authRoleBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("删除用户角色信息失败，原因：{}", e.getMessage());
            return Result.fail("删除用户角色信息失败~");
        }
    }

    /**
     * 通过主键ID删除角色表
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    // @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        authRoleService.remove(ids);
        return null;
    }
}
