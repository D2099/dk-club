package com.dk.auth.application.convert;

import com.dk.auth.application.dto.AuthUserDto;
import com.dk.auth.domain.bo.AuthUserBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户DTO转换类
 */
@Mapper
public interface AuthUserDTOConverter {

    AuthUserDTOConverter INSTANCE = Mappers.getMapper(AuthUserDTOConverter.class);

    AuthUserBo convertAuthUserBo(AuthUserDto authUserDto);
}
