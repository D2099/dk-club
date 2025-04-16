package com.dk.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.dk.auth.common.constant.UserRoleConstant;
import com.dk.auth.common.enums.DeleteFlagEnum;
import com.dk.auth.common.enums.UserStatusEnum;
import com.dk.auth.common.utils.GeneralUtil;
import com.dk.auth.domain.bo.AuthUserBo;
import com.dk.auth.domain.convert.AuthUserDomainConverter;
import com.dk.auth.domain.redis.RedisUtil;
import com.dk.auth.domain.service.AuthUserDomainService;
import com.dk.auth.infra.basic.entity.*;
import com.dk.auth.infra.basic.service.*;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private AuthPermissionService authPermissionService;

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    @Resource
    private RedisUtil redisUtil;

    private String permissionPrefix = "auth.permission";

    private String rolePrefix = "auth.role";

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean register(AuthUserBo authUserBo) {
        if (log.isInfoEnabled()) {
            log.info("AuthUserDomainServiceImpl.register.authUserBo:{}", authUserBo);
        }
        AuthUser authUser = AuthUserDomainConverter.INSTANCE.convertAuthUser(authUserBo);
        authUser.setStatus(UserStatusEnum.OPEN.getCode());
        authUser.setDelFlag(DeleteFlagEnum.UN_DELETE.getCode());
        // 生成随机密码盐
        String salt = GeneralUtil.randomGen(8);
        // aes加密
        String aesEncryptPW = SaSecureUtil.aesEncrypt(salt, authUserBo.getPassword());
        authUser.setPassword(aesEncryptPW);
        authUser.setSalt(salt);
        Integer addRow = authUserService.add(authUser);
        // 查询普通用户角色
        AuthRole authRole = new AuthRole().setRoleKey(UserRoleConstant.NORMAL_USER);
        AuthRole roleResult = authRoleService.getAuthRoleByConditions(authRole);
        // 新增关联角色信息
        AuthUserRole authUserRole = new AuthUserRole()
                .setUserId(authUser.getId())
                .setRoleId(roleResult.getId());
        authUserRoleService.add(authUserRole);

        // 向缓存添加用户默认角色权限
        // 缓存用户角色
        String roleKey = redisUtil.buildKey(rolePrefix, String.valueOf(authUser.getId()));
        List<AuthRole> roleList = new ArrayList<>();
        roleList.add(roleResult);
        redisUtil.set(roleKey, new Gson().toJson(roleList));
        // 权限
        // 查询用户角色关联权限
        List<Long> roleIds = roleList.stream().map(AuthRole::getId).toList();
        List<AuthRolePermission> rolePermissionList = authRolePermissionService.getAuthRolePermissionByRoleIds(roleIds);
        // 获取到所有权限ID
        List<Long> permissions = rolePermissionList.stream().map(AuthRolePermission::getPermissionId).toList();
        if (!permissions.isEmpty()) {
            List<AuthPermission> authPermissionList = authPermissionService.getPermissionByIds(permissions);
            // 缓存用户权限
            String permissionKey = redisUtil.buildKey(permissionPrefix, String.valueOf(authUser.getId()));
            redisUtil.set(permissionKey, new Gson().toJson(authPermissionList));
        }
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

    @Override
    public AuthUserBo getUserByUsername(String username) {
        AuthUser authUser = authUserService.getAuthUserByUsername(username);
        return AuthUserDomainConverter.INSTANCE.convertAuthUserBo(authUser);
    }

    @Override
    public SaResult login(String username, String password) {
        // 1.通过用户名查询用户信息
        AuthUserBo authUserBo = getUserByUsername(username);
        if (authUserBo == null) {
            return SaResult.error("用户不存在~");
        }
        // aes解密
        String decryptPw = SaSecureUtil.aesDecrypt(authUserBo.getSalt(), authUserBo.getPassword());
        if (!password.equals(decryptPw)) {
            return SaResult.error("用户名或密码不正确~");
        }
        StpUtil.login(authUserBo.getId());
        // 第2步，获取 Token  相关参数
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        // 第3步，返回给前端
        return SaResult.data(tokenInfo);
    }
}
