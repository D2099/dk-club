package com.dk.auth.application.convert;

import com.dk.auth.application.dto.AuthRoleDto;
import com.dk.auth.domain.bo.AuthRoleBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户角色DTO转换类
 */
@Mapper
public interface AuthRoleDTOConverter {

    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);

    AuthRoleBo convertAuthRoleBo(AuthRoleDto authRoleDto);
}
