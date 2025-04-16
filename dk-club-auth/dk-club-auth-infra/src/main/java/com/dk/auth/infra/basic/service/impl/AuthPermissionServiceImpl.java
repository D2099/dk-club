package com.dk.auth.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dk.auth.infra.basic.entity.AuthPermission;
import com.dk.auth.infra.basic.mapper.AuthPermissionMapper;
import com.dk.auth.infra.basic.service.AuthPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 权限表 服务实现类
 * @author DEMOKING
 * @since 2025-04-15
 */
@Service
public class AuthPermissionServiceImpl extends ServiceImpl<AuthPermissionMapper, AuthPermission> implements AuthPermissionService {

    @Autowired
    AuthPermissionMapper authPermissionMapper;

    @Override
    public AuthPermission getAuthPermission(Long id) {
        return authPermissionMapper.selectById(id);
    }

    @Override
    public List<AuthPermission> getAllAuthPermission() {
        return authPermissionMapper.selectList(null);
    }

    @Override
    public int add(AuthPermission authPermission) {
        return authPermissionMapper.insert(authPermission);
    }

    @Override
    public int modify(AuthPermission authPermission) {
        // 乐观锁更新
        // AuthPermission currentAuthPermission = authPermissionMapper.selectById(authPermission.getId());
        // authPermission.setVersion(currentAuthPermission.getVersion());
        return authPermissionMapper.updateById(authPermission);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                authPermissionMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

    @Override
    public List<AuthPermission> getPermissionByIds(List<Long> permissions) {
        return authPermissionMapper.selectList(new LambdaQueryWrapper<AuthPermission>()
                .in(AuthPermission::getId, permissions));
    }

}


