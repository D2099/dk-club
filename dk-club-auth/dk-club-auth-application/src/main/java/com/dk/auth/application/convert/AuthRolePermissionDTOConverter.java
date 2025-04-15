package com.dk.auth.application.convert;

import com.dk.auth.application.dto.AuthPermissionDto;
import com.dk.auth.application.dto.AuthRolePermissionDto;
import com.dk.auth.domain.bo.AuthPermissionBo;
import com.dk.auth.domain.bo.AuthRolePermissionBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户角色DTO转换类
 */
@Mapper
public interface AuthRolePermissionDTOConverter {

    AuthRolePermissionDTOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConverter.class);

    AuthRolePermissionBo convertAuthRolePermissionBo(AuthRolePermissionDto authRolePermissionDto);
}
