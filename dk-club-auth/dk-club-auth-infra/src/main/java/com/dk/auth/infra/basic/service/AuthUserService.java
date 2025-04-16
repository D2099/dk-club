package com.dk.auth.infra.basic.service;

import com.dk.auth.infra.basic.entity.AuthUser;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author DEMOKING
 * @since 2025-03-18
 */
public interface AuthUserService extends IService<AuthUser> {

    /**
     * 用户表根据主键ID获取详情
     * @param id 主键ID
     * @return
     */
    AuthUser getAuthUser(Long id);

    /**
     * 用户表获取全部详情
     * @param
     * @return
     */
    List<AuthUser> getAllAuthUser();

    /**
     * 用户表新增
     * @param authUser 根据需要进行传值
     * @return
     */
    Integer add(AuthUser authUser);

    /**
     * 用户表修改
     * @param authUser 根据需要进行传值
     * @return
     */
    int modify(AuthUser authUser);

    /**
     * 用户表删除
     * @param ids
     * @return
     */
    void remove(String ids);

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    AuthUser getAuthUserByUsername(String username);
}


