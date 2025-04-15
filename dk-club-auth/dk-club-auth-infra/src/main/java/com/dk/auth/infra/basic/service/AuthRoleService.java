package com.dk.auth.infra.basic.service;

import com.dk.auth.infra.basic.entity.AuthRole;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-04-14
 */
public interface AuthRoleService extends IService<AuthRole> {

    /**
     * 角色表根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    AuthRole getAuthRole(Long id);

    /**
     * 角色表获取全部详情
     * @param
     * @return
     */
    List<AuthRole> getAllAuthRole();

    /**
     * 角色表新增
     * @param authRole 根据需要进行传值
     * @return
     */
    int add(AuthRole authRole);

    /**
     * 角色表修改
     * @param authRole 根据需要进行传值
     * @return
     */
    int modify(AuthRole authRole);

    /**
     * 角色表删除
     * @param ids
     * @return
     */
    void remove(String ids);

    /**
     * 通过多条件获取角色信息
     * @param authRole
     * @return
     */
    AuthRole getAuthRoleByConditions(AuthRole authRole);
}


