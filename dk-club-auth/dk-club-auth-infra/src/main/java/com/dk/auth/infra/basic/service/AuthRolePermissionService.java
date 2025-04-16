package com.dk.auth.infra.basic.service;

import com.dk.auth.infra.basic.entity.AuthRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-04-15
 */
public interface AuthRolePermissionService extends IService<AuthRolePermission> {

    /**
     * 角色权限关系表根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    AuthRolePermission getAuthRolePermission(Long id);

    /**
     * 角色权限关系表获取全部详情
     * @param
     * @return
     */
    List<AuthRolePermission> getAllAuthRolePermission();

    /**
     * 角色权限关系表新增
     * @param authRolePermission 根据需要进行传值
     * @return
     */
    int add(AuthRolePermission authRolePermission);

    /**
     * 角色权限关系表修改
     * @param authRolePermission 根据需要进行传值
     * @return
     */
    int modify(AuthRolePermission authRolePermission);

    /**
     * 角色权限关系表删除
     * @param ids
     * @return
     */
    void remove(String ids);

    /**
     * 根据角色ID列表查询角色关联权限ID列表
     * @param roleIds
     * @return
     */
    List<AuthRolePermission> getAuthRolePermissionByRoleIds(List<Long> roleIds);
}


