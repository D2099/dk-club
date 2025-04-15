package com.dk.auth.domain.service;

import com.dk.auth.domain.bo.AuthRoleBo;
import com.dk.auth.domain.bo.AuthUserBo;

/**
 * 用户角色Domain接口
 */
public interface AuthRoleDomainService {
    /**
     * 新增角色
     * @param authRoleBo
     * @return
     */
    Boolean add(AuthRoleBo authRoleBo);

    /**
     * 更新角色信息
     * @param authRoleBo
     * @return
     */
    Boolean update(AuthRoleBo authRoleBo);

    /**
     * 删除用户角色信息
     * @param authRoleBo
     * @return
     */
    Boolean delete(AuthRoleBo authRoleBo);
}
