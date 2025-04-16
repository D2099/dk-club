package com.dk.auth.infra.basic.service;

import com.dk.auth.infra.basic.entity.AuthPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-04-15
 */
public interface AuthPermissionService extends IService<AuthPermission> {

    /**
     * 权限表根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    AuthPermission getAuthPermission(Long id);

    /**
     * 权限表获取全部详情
     * @param
     * @return
     */
    List<AuthPermission> getAllAuthPermission();

    /**
     * 权限表新增
     * @param authPermission 根据需要进行传值
     * @return
     */
    int add(AuthPermission authPermission);

    /**
     * 权限表修改
     * @param authPermission 根据需要进行传值
     * @return
     */
    int modify(AuthPermission authPermission);

    /**
     * 权限表删除
     * @param ids
     * @return
     */
    void remove(String ids);

    /**
     * 通过ID列表获取全部权限
     * @param permissions
     * @return
     */
    List<AuthPermission> getPermissionByIds(List<Long> permissions);
}


