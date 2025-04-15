package com.dk.auth.domain.service;

import com.dk.auth.domain.bo.AuthPermissionBo;
import com.dk.auth.domain.bo.AuthRolePermissionBo;

/**
 * 权限Domain接口
 */
public interface AuthRolePermissionDomainService {

    /**
     * 新增角色权限关联信息
     * @param authRolePermissionBo
     * @return
     */
    Boolean add(AuthRolePermissionBo authRolePermissionBo);
}
