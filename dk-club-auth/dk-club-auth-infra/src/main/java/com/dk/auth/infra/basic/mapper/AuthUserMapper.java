package com.dk.auth.infra.basic.mapper;

import com.dk.auth.infra.basic.entity.AuthUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表 Mapper接口
 * @author DEMOKING
 * @since 2025-03-18
 */
@Mapper
public interface AuthUserMapper extends BaseMapper<AuthUser> {
}
