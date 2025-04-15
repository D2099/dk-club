package com.dk.auth.infra.basic.service.impl;

import com.dk.auth.infra.basic.entity.AuthRolePermission;
import com.dk.auth.infra.basic.mapper.AuthRolePermissionMapper;
import com.dk.auth.infra.basic.service.AuthRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 角色权限关系表 服务实现类
 * @author DEMOKING
 * @since 2025-04-15
 */
@Service
public class AuthRolePermissionServiceImpl extends ServiceImpl<AuthRolePermissionMapper, AuthRolePermission> implements AuthRolePermissionService {

    @Autowired
    AuthRolePermissionMapper authRolePermissionMapper;

    @Override
    public AuthRolePermission getAuthRolePermission(Long id) {
        return authRolePermissionMapper.selectById(id);
    }

    @Override
    public List<AuthRolePermission> getAllAuthRolePermission() {
        return authRolePermissionMapper.selectList(null);
    }

    @Override
    public int add(AuthRolePermission authRolePermission) {
        return authRolePermissionMapper.insert(authRolePermission);
    }

    @Override
    public int modify(AuthRolePermission authRolePermission) {
        // 乐观锁更新
        // AuthRolePermission currentAuthRolePermission = authRolePermissionMapper.selectById(authRolePermission.getId());
        // authRolePermission.setVersion(currentAuthRolePermission.getVersion());
        return authRolePermissionMapper.updateById(authRolePermission);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                authRolePermissionMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

}


