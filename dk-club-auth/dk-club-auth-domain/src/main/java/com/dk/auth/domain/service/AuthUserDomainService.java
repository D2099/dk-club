package com.dk.auth.domain.service;

import com.dk.auth.domain.bo.AuthUserBo;

/**
 * 用户Domain接口
 */
public interface AuthUserDomainService {

    /**
     * 用户注册
     * @param authUserBo
     * @return
     */
    Boolean register(AuthUserBo authUserBo);

    /**
     * 更新用户信息
     * @param authUserBo
     * @return
     */
    Boolean updateInfo(AuthUserBo authUserBo);

    /**
     * 伪删除用户
     * @param authUserBo
     * @return
     */
    Boolean deleteUser(AuthUserBo authUserBo);

    /**
     * 更新用户状态
     * @param authUserBo
     * @return
     */
    Boolean changeStatus(AuthUserBo authUserBo);
}
