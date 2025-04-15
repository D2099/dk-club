package com.dk.auth.infra.basic.service.impl;

import com.dk.auth.infra.basic.entity.AuthUserRole;
import com.dk.auth.infra.basic.mapper.AuthUserRoleMapper;
import com.dk.auth.infra.basic.service.AuthUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 用户角色关系表 服务实现类
 * @author DEMOKING
 * @since 2025-04-15
 */
@Service
public class AuthUserRoleServiceImpl extends ServiceImpl<AuthUserRoleMapper, AuthUserRole> implements AuthUserRoleService {

    @Autowired
    AuthUserRoleMapper authUserRoleMapper;

    @Override
    public AuthUserRole getAuthUserRole(Long id) {
        return authUserRoleMapper.selectById(id);
    }

    @Override
    public List<AuthUserRole> getAllAuthUserRole() {
        return authUserRoleMapper.selectList(null);
    }

    @Override
    public void add(AuthUserRole authUserRole) {
        authUserRoleMapper.insert(authUserRole);
    }

    @Override
    public int modify(AuthUserRole authUserRole) {
        // 乐观锁更新
        // AuthUserRole currentAuthUserRole = authUserRoleMapper.selectById(authUserRole.getId());
        // authUserRole.setVersion(currentAuthUserRole.getVersion());
        return authUserRoleMapper.updateById(authUserRole);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                authUserRoleMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

}


