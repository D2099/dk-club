package com.dk.auth.domain.service;

import com.dk.auth.domain.bo.AuthPermissionBo;
import com.dk.auth.domain.bo.AuthRoleBo;

/**
 * 权限Domain接口
 */
public interface AuthPermissionDomainService {

    /**
     * 新增权限
     * @param authPermissionBo
     * @return
     */
    Boolean add(AuthPermissionBo authPermissionBo);
}
