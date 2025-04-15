package com.dk.auth.application.convert;

import com.dk.auth.application.dto.AuthPermissionDto;
import com.dk.auth.domain.bo.AuthPermissionBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户角色DTO转换类
 */
@Mapper
public interface AuthPermissionDTOConverter {

    AuthPermissionDTOConverter INSTANCE = Mappers.getMapper(AuthPermissionDTOConverter.class);

    AuthPermissionBo convertAuthPermissionBo(AuthPermissionDto authPermissionDto);
}
