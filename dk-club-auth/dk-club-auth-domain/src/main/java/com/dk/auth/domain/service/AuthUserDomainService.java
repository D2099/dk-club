package com.dk.auth.domain.service;

import com.dk.auth.domain.bo.AuthUserBo;

/**
 * 用户Domain接口
 */
public interface AuthUserDomainService {
    Boolean register(AuthUserBo authUserBo);
}
