package com.dk.auth.infra.basic.service.impl;

import com.dk.auth.infra.basic.entity.AuthRole;
import com.dk.auth.infra.basic.mapper.AuthRoleMapper;
import com.dk.auth.infra.basic.service.AuthRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 角色表 服务实现类
 * @author DEMOKING
 * @since 2025-04-14
 */
@Service
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleMapper, AuthRole> implements AuthRoleService {

    @Autowired
    AuthRoleMapper authRoleMapper;

    @Override
    public AuthRole getAuthRole(Long id) {
        return authRoleMapper.selectById(id);
    }

    @Override
    public List<AuthRole> getAllAuthRole() {
        return authRoleMapper.selectList(null);
    }

    @Override
    public int add(AuthRole authRole) {
        return authRoleMapper.insert(authRole);
    }

    @Override
    public int modify(AuthRole authRole) {
        // 乐观锁更新
        // AuthRole currentAuthRole = authRoleMapper.selectById(authRole.getId());
        // authRole.setVersion(currentAuthRole.getVersion());
        return authRoleMapper.updateById(authRole);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                authRoleMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

    @Override
    public AuthRole getAuthRoleByConditions(AuthRole authRole) {
        return authRoleMapper.queryAuthRoleByConditions(authRole);
    }

}


