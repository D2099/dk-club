package com.dk.auth.domain.convert;

import com.dk.auth.domain.bo.AuthUserBo;
import com.dk.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户BO转换类
 */
@Mapper
public interface AuthUserDomainConverter {

    AuthUserDomainConverter INSTANCE = Mappers.getMapper(AuthUserDomainConverter.class);

    AuthUser convertAuthUser(AuthUserBo authUserBo);

    AuthUserBo convertAuthUserBo(AuthUser authUser);
}
