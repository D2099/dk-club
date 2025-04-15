package com.dk.auth.domain.convert;

import com.dk.auth.domain.bo.AuthRoleBo;
import com.dk.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户角色BO转换类
 */
@Mapper
public interface AuthRoleDomainConverter {

    AuthRoleDomainConverter INSTANCE = Mappers.getMapper(AuthRoleDomainConverter.class);

    AuthRole convertAuthRole(AuthRoleBo authRoleBo);
}
