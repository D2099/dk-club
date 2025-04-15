package com.dk.auth.domain.service.impl;

import com.dk.auth.common.enums.DeleteFlagEnum;
import com.dk.auth.domain.bo.AuthRoleBo;
import com.dk.auth.domain.convert.AuthRoleDomainConverter;
import com.dk.auth.domain.service.AuthRoleDomainService;
import com.dk.auth.infra.basic.entity.AuthRole;
import com.dk.auth.infra.basic.service.AuthRoleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户角色Domain接口实现类
 */
@Slf4j
@Service
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;

    @Override
    public Boolean add(AuthRoleBo authRoleBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthRoleDomainServiceImpl.add.authRoleBo: {}", authRoleBo);
        }
        AuthRole authRole = AuthRoleDomainConverter.INSTANCE.convertAuthRole(authRoleBo);
        int row = authRoleService.add(authRole);
        return row > 0;
    }

    @Override
    public Boolean update(AuthRoleBo authRoleBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthRoleDomainServiceImpl.update.authRoleBo: {}", authRoleBo);
        }
        AuthRole authRole = AuthRoleDomainConverter.INSTANCE.convertAuthRole(authRoleBo);
        return authRoleService.updateById(authRole);
    }

    @Override
    public Boolean delete(AuthRoleBo authRoleBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthRoleDomainServiceImpl.delete.authRoleBo: {}", authRoleBo);
        }
        AuthRole authRole = AuthRoleDomainConverter.INSTANCE.convertAuthRole(authRoleBo);
        return authRoleService.removeById(authRole);
    }
}
