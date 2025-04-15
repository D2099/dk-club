package com.dk.auth.application.controller;

import com.dk.auth.application.convert.AuthRolePermissionDTOConverter;
import com.dk.auth.application.dto.AuthRolePermissionDto;
import com.dk.auth.common.entity.Result;
import com.dk.auth.domain.bo.AuthRolePermissionBo;
import com.dk.auth.domain.service.AuthRolePermissionDomainService;
import com.dk.auth.domain.service.impl.AuthRolePermissionDomainServiceImpl;
import com.dk.auth.infra.basic.entity.AuthRolePermission;
import com.dk.auth.infra.basic.service.AuthRolePermissionService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
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

    @Resource
    private AuthRolePermissionDomainService authRolePermissionDomainService;

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
     * 新增角色权限关系信息
     * @param authRolePermission com.dk.auth.application.dto.AuthRolePermissionDto
     */
    @PostMapping("/add")
    public Result<Boolean> add(@Valid @RequestBody AuthRolePermissionDto authRolePermission) {
        if (log.isInfoEnabled()) {
            log.info("AuthRolePermissionController.add.authRolePermission：{}", authRolePermission);
        }
        try {
            Preconditions.checkNotNull(authRolePermission.getRoleId(), "角色ID不能为空~");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(authRolePermission.getPermissionIds()), "权限列表不能为空~");
            AuthRolePermissionBo authRolePermissionBo = AuthRolePermissionDTOConverter.INSTANCE.convertAuthRolePermissionBo(authRolePermission);
            return Result.ok(authRolePermissionDomainService.add(authRolePermissionBo));
        } catch (Exception e) {
            log.error("新增角色权限关联信息失败，原因：{}", e.getMessage());
            return Result.fail("新增角色权限关联信息失败~");
        }
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
