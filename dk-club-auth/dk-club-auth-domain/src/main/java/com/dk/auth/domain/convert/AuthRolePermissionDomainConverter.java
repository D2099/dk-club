package com.dk.auth.domain.convert;

import com.dk.auth.domain.bo.AuthRolePermissionBo;
import com.dk.auth.infra.basic.entity.AuthRolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色权限关联BO转换类
 */
@Mapper
public interface AuthRolePermissionDomainConverter {

    AuthRolePermissionDomainConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDomainConverter.class);

    AuthRolePermission convertAuthRolePermission(AuthRolePermissionBo authRolePermissionBo);
}
