package com.dk.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.dk.auth.common.enums.DeleteFlagEnum;
import com.dk.auth.common.enums.UserStatusEnum;
import com.dk.auth.domain.bo.AuthUserBo;
import com.dk.auth.domain.convert.AuthUserDTOConverter;
import com.dk.auth.domain.service.AuthUserDomainService;
import com.dk.auth.infra.basic.entity.AuthUser;
import com.dk.auth.infra.basic.service.AuthUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户Domain接口实现类
 */
@Slf4j
@Service
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;

    private String encryptKey = "dk-club";

    @Override
    public Boolean register(AuthUserBo authUserBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthUserDomainServiceImpl.register.authUserBo:{}", authUserBo);
        }
        AuthUser authUser = AuthUserDTOConverter.INSTANCE.convertAuthUser(authUserBo);
        authUser.setStatus(UserStatusEnum.OPEN.getCode());
        authUser.setDelFlag(DeleteFlagEnum.UN_DELETE.getCode());
        // aes加密
        String aesEncryptPW = SaSecureUtil.aesEncrypt(encryptKey, authUserBo.getPassword());
        authUser.setPassword(aesEncryptPW);
        Integer addRow = authUserService.add(authUser);
        return addRow > 0;
    }

    @Override
    public Boolean updateInfo(AuthUserBo authUserBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthUserDomainServiceImpl.updateInfo.authUserBo:{}", authUserBo);
        }
        AuthUser authUser = AuthUserDTOConverter.INSTANCE.convertAuthUser(authUserBo);
        return authUserService.updateById(authUser);
    }
}
