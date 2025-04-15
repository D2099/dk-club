package com.dk.auth.application.controller;

import com.dk.auth.application.convert.AuthPermissionDTOConverter;
import com.dk.auth.application.dto.AuthPermissionDto;
import com.dk.auth.common.entity.Result;
import com.dk.auth.domain.bo.AuthPermissionBo;
import com.dk.auth.domain.service.AuthPermissionDomainService;
import com.dk.auth.infra.basic.entity.AuthPermission;
import com.dk.auth.infra.basic.service.AuthPermissionService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private AuthPermissionDomainService authPermissionDomainService;

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
     * @param authPermission com.dk.auth.application.dto.AuthPermissionDto
     */
    @PostMapping("/add")
    public Result<Boolean> add(@Valid @RequestBody AuthPermissionDto authPermission) {
        if (log.isInfoEnabled()) {
            log.info("AuthPermissionController.add.authPermission: {}", authPermission);
        }
        try {
            Preconditions.checkNotNull(authPermission.getName(), "权限名称不能为空~");
            Preconditions.checkNotNull(authPermission.getParentId(), "父ID不能为空~");
            Preconditions.checkNotNull(authPermission.getType(), "类型不能为空~");
            Preconditions.checkNotNull(authPermission.getPermissionKey(), "唯一标识不能为空~");
            AuthPermissionBo authPermissionBo = AuthPermissionDTOConverter.INSTANCE.convertAuthPermissionBo(authPermission);
            boolean result = authPermissionDomainService.add(authPermissionBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("新增权限信息失败，原因：{}", e.getMessage());
            return Result.fail("新增权限信息失败~");
        }
    }

    /**
     * 更新权限信息
     * @param authPermission com.dk.auth.application.dto.AuthPermissionDto
     */
    @PostMapping("/update")
    public Result<Boolean> update(@Valid @RequestBody AuthPermissionDto authPermission) {
        if (log.isInfoEnabled()) {
            log.info("AuthPermissionController.update.authPermission: {}", authPermission);
        }
        try {
            Preconditions.checkNotNull(authPermission.getId(), "ID不能为空~");
            AuthPermissionBo authPermissionBo = AuthPermissionDTOConverter.INSTANCE.convertAuthPermissionBo(authPermission);
            boolean result = authPermissionDomainService.update(authPermissionBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("更新权限信息失败，原因：{}", e.getMessage());
            return Result.fail("更新权限信息失败~");
        }
    }

    /**
     * 删除权限信息
     * @param authPermission com.dk.auth.application.dto.AuthPermissionDto
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@Valid @RequestBody AuthPermissionDto authPermission) {
        if (log.isInfoEnabled()) {
            log.info("AuthPermissionController.delete.authPermission: {}", authPermission);
        }
        try {
            Preconditions.checkNotNull(authPermission.getId(), "ID不能为空~");
            AuthPermissionBo authPermissionBo = AuthPermissionDTOConverter.INSTANCE.convertAuthPermissionBo(authPermission);
            boolean result = authPermissionDomainService.delete(authPermissionBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("删除权限信息失败，原因：{}", e.getMessage());
            return Result.fail("删除权限信息失败~");
        }
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
