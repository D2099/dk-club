package com.dk.auth.domain.service.impl;

import com.dk.auth.domain.bo.AuthPermissionBo;
import com.dk.auth.domain.bo.AuthRoleBo;
import com.dk.auth.domain.convert.AuthPermissionDomainConverter;
import com.dk.auth.domain.convert.AuthRoleDomainConverter;
import com.dk.auth.domain.service.AuthPermissionDomainService;
import com.dk.auth.domain.service.AuthRoleDomainService;
import com.dk.auth.infra.basic.entity.AuthPermission;
import com.dk.auth.infra.basic.entity.AuthRole;
import com.dk.auth.infra.basic.service.AuthPermissionService;
import com.dk.auth.infra.basic.service.AuthRoleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 权限Domain接口实现类
 */
@Slf4j
@Service
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {

    @Resource
    private AuthPermissionService authPermissionService;

    @Override
    public Boolean add(AuthPermissionBo authPermissionBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthPermissionDomainServiceImpl.add.authPermissionBo：{}", authPermissionBo);
        }
        AuthPermission authPermission = AuthPermissionDomainConverter.INSTANCE.convertAuthPermission(authPermissionBo);
        int row = authPermissionService.add(authPermission);
        return row > 0;
    }

    @Override
    public boolean update(AuthPermissionBo authPermissionBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthPermissionDomainServiceImpl.update.authPermissionBo：{}", authPermissionBo);
        }
        AuthPermission authPermission = AuthPermissionDomainConverter.INSTANCE.convertAuthPermission(authPermissionBo);
        return authPermissionService.updateById(authPermission);
    }

    @Override
    public boolean delete(AuthPermissionBo authPermissionBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthPermissionDomainServiceImpl.delete.authPermissionBo：{}", authPermissionBo);
        }
        AuthPermission authPermission = AuthPermissionDomainConverter.INSTANCE.convertAuthPermission(authPermissionBo);
        return authPermissionService.removeById(authPermission);
    }
}
