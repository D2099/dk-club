package com.dk.auth.domain.convert;

import com.dk.auth.domain.bo.AuthPermissionBo;
import com.dk.auth.domain.bo.AuthRoleBo;
import com.dk.auth.infra.basic.entity.AuthPermission;
import com.dk.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 权限BO转换类
 */
@Mapper
public interface AuthPermissionDomainConverter {

    AuthPermissionDomainConverter INSTANCE = Mappers.getMapper(AuthPermissionDomainConverter.class);

    AuthPermission convertAuthPermission(AuthPermissionBo authPermissionBo);
}
