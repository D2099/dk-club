package com.dk.auth.domain.convert;

import com.dk.auth.domain.bo.AuthUserBo;
import com.dk.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户BO转换类
 */
@Mapper
public interface AuthUserDTOConverter {

    AuthUserDTOConverter INSTANCE = Mappers.getMapper(AuthUserDTOConverter.class);

    AuthUser convertAuthUser(AuthUserBo authUserBo);
}
