package com.dk.auth.infra.basic.service.impl;

import com.dk.auth.infra.basic.entity.AuthUser;
import com.dk.auth.infra.basic.mapper.AuthUserMapper;
import com.dk.auth.infra.basic.service.AuthUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;

/**
 * 用户表 服务实现类
 * @author DEMOKING
 * @since 2025-03-18
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements AuthUserService {

    @Autowired
    AuthUserMapper authUserMapper;

    @Override
    public AuthUser getAuthUser(Long id) {
        return authUserMapper.selectById(id);
    }

    @Override
    public List<AuthUser> getAllAuthUser() {
        return authUserMapper.selectList(null);
    }

    @Override
    public Integer add(AuthUser authUser) {
        return authUserMapper.insert(authUser);
    }

    @Override
    public int modify(AuthUser authUser) {
        // 乐观锁更新
        // AuthUser currentAuthUser = authUserMapper.selectById(authUser.getId());
        // authUser.setVersion(currentAuthUser.getVersion());
        return authUserMapper.updateById(authUser);
    }

    @Override
    public void remove(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                authUserMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

}


