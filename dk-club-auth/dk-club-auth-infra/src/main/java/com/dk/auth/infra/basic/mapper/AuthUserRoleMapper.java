package com.dk.auth.infra.basic.mapper;

import com.dk.auth.infra.basic.entity.AuthUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户角色关系表 Mapper接口
 * @author DEMOKING
 * @since 2025-04-15
 */
@Mapper
public interface AuthUserRoleMapper extends BaseMapper<AuthUserRole> {
}
