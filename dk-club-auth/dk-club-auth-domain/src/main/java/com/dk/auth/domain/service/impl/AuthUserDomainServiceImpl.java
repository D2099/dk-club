package com.dk.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.dk.auth.common.constant.UserRoleConstant;
import com.dk.auth.common.enums.DeleteFlagEnum;
import com.dk.auth.common.enums.UserStatusEnum;
import com.dk.auth.domain.bo.AuthUserBo;
import com.dk.auth.domain.convert.AuthUserDomainConverter;
import com.dk.auth.domain.service.AuthUserDomainService;
import com.dk.auth.infra.basic.entity.AuthRole;
import com.dk.auth.infra.basic.entity.AuthUser;
import com.dk.auth.infra.basic.entity.AuthUserRole;
import com.dk.auth.infra.basic.service.AuthRoleService;
import com.dk.auth.infra.basic.service.AuthUserRoleService;
import com.dk.auth.infra.basic.service.AuthUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Domain接口实现类
 */
@Slf4j
@Service
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private AuthRoleService authRoleService;

    @Resource
    private AuthUserRoleService authUserRoleService;

    private String encryptKey = "dk-club";

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean register(AuthUserBo authUserBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthUserDomainServiceImpl.register.authUserBo:{}", authUserBo);
        }
        AuthUser authUser = AuthUserDomainConverter.INSTANCE.convertAuthUser(authUserBo);
        authUser.setStatus(UserStatusEnum.OPEN.getCode());
        authUser.setDelFlag(DeleteFlagEnum.UN_DELETE.getCode());
        // aes加密
        String aesEncryptPW = SaSecureUtil.aesEncrypt(encryptKey, authUserBo.getPassword());
        authUser.setPassword(aesEncryptPW);
        Integer addRow = authUserService.add(authUser);
        // 查询普通用户角色
        AuthRole authRole = new AuthRole().setRoleKey(UserRoleConstant.NORMAL_USER);
        AuthRole roleResult = authRoleService.getAuthRoleByConditions(authRole);
        // 新增关联角色信息
        AuthUserRole authUserRole = new AuthUserRole()
                .setUserId(authUser.getId())
                .setRoleId(roleResult.getId());
        authUserRoleService.add(authUserRole);
        return addRow > 0;
    }

    @Override
    public Boolean updateInfo(AuthUserBo authUserBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthUserDomainServiceImpl.updateInfo.authUserBo:{}", authUserBo);
        }
        AuthUser authUser = AuthUserDomainConverter.INSTANCE.convertAuthUser(authUserBo);
        return authUserService.updateById(authUser);
    }

    @Override
    public Boolean deleteUser(AuthUserBo authUserBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthUserDomainServiceImpl.deleteUser.authUserBo:{}", authUserBo);
        }
        AuthUser authUser = AuthUserDomainConverter.INSTANCE.convertAuthUser(authUserBo);
        return authUserService.removeById(authUser);
    }

    @Override
    public Boolean changeStatus(AuthUserBo authUserBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthUserDomainServiceImpl.changeStatus.authUserBo:{}", authUserBo);
        }
        AuthUser authUser = AuthUserDomainConverter.INSTANCE.convertAuthUser(authUserBo);
        return authUserService.updateById(authUser);
    }
}
