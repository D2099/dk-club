package com.dk.auth.infra.basic.mapper;

import com.dk.auth.infra.basic.entity.AuthRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色表 Mapper接口
 * @author DEMOKING
 * @since 2025-04-14
 */
@Mapper
public interface AuthRoleMapper extends BaseMapper<AuthRole> {
    AuthRole queryAuthRoleByConditions(AuthRole authRole);
}
