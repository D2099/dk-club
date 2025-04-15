package com.dk.auth.domain.service;

import com.dk.auth.domain.bo.AuthPermissionBo;
import com.dk.auth.domain.bo.AuthRoleBo;

/**
 * 权限Domain接口
 */
public interface AuthPermissionDomainService {

    /**
     * 新增权限信息
     * @param authPermissionBo
     * @return
     */
    Boolean add(AuthPermissionBo authPermissionBo);

    /**
     * 更新权限信息
     * @param authPermissionBo
     * @return
     */
    boolean update(AuthPermissionBo authPermissionBo);

    /**
     * 删除权限信息
     * @param authPermissionBo
     * @return
     */
    boolean delete(AuthPermissionBo authPermissionBo);
}
