package com.dk.auth.domain.service.impl;

import com.dk.auth.domain.bo.AuthPermissionBo;
import com.dk.auth.domain.bo.AuthRolePermissionBo;
import com.dk.auth.domain.convert.AuthPermissionDomainConverter;
import com.dk.auth.domain.convert.AuthRolePermissionDomainConverter;
import com.dk.auth.domain.service.AuthPermissionDomainService;
import com.dk.auth.domain.service.AuthRolePermissionDomainService;
import com.dk.auth.infra.basic.entity.AuthPermission;
import com.dk.auth.infra.basic.entity.AuthRolePermission;
import com.dk.auth.infra.basic.service.AuthPermissionService;
import com.dk.auth.infra.basic.service.AuthRolePermissionService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色权限关联Domain接口实现类
 */
@Slf4j
@Service
public class AuthRolePermissionDomainServiceImpl implements AuthRolePermissionDomainService {

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    @Override
    public Boolean add(AuthRolePermissionBo authRolePermissionBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthPermissionDomainServiceImpl.add.authRolePermissionBo：{}", authRolePermissionBo);
        }
        Long roleId = authRolePermissionBo.getRoleId();
        List<AuthRolePermission> rolePermissionList = authRolePermissionBo.getPermissionIds().stream().map(permissionId -> new AuthRolePermission()
                .setRoleId(roleId)
                .setPermissionId(permissionId)
        ).toList();
        return authRolePermissionService.saveBatch(rolePermissionList);
    }
}
