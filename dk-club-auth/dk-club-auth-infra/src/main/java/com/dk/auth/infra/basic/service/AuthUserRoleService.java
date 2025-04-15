package com.dk.auth.infra.basic.service;

import com.dk.auth.infra.basic.entity.AuthUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-04-15
 */
public interface AuthUserRoleService extends IService<AuthUserRole> {

    /**
     * 用户角色关系表根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    AuthUserRole getAuthUserRole(Long id);

    /**
     * 用户角色关系表获取全部详情
     * @param
     * @return
     */
    List<AuthUserRole> getAllAuthUserRole();

    /**
     * 用户角色关系表新增
     * @param authUserRole 根据需要进行传值
     * @return
     */
    void add(AuthUserRole authUserRole);

    /**
     * 用户角色关系表修改
     * @param authUserRole 根据需要进行传值
     * @return
     */
    int modify(AuthUserRole authUserRole);

    /**
     * 用户角色关系表删除
     * @param ids
     * @return
     */
    void remove(String ids);
}


