package com.dk.auth.application.controller;

import com.dk.auth.application.convert.AuthUserDTOConverter;
import com.dk.auth.application.dto.AuthUserDto;
import com.dk.auth.common.entity.Result;
import com.dk.auth.domain.bo.AuthUserBo;
import com.dk.auth.domain.service.AuthUserDomainService;
import com.dk.auth.infra.basic.entity.AuthUser;
import com.dk.auth.infra.basic.service.AuthUserService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户表 接口控制器
 *
 * @author DEMOKING
 * @since 2025-03-18
 */
@Slf4j
@RestController
@RequestMapping("/auth-user")
public class AuthUserController {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private AuthUserDomainService authUserDomainService;

    /**
     * 通过主键ID查询一个用户表
     *
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
    public AuthUser getAuthUser(@RequestParam("id") Long id) {
        AuthUser authUserOne = authUserService.getAuthUser(id);
        return authUserOne;
    }

    /**
     * 查询全部用户表
     */
    @GetMapping("/listAll")
    public List<AuthUser> getAllAuthUser() {
        List<AuthUser> authUserList = authUserService.getAllAuthUser();
        return authUserList;
    }

    /**
     * 新增用户表
     *
     * @param authUser com.dk.auth.infra.basic.entity.AuthUser
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody AuthUser authUser) {
        authUserService.add(authUser);
        return null;
    }

    /**
     * 更新用户表
     *
     * @param authUser com.dk.auth.infra.basic.entity.AuthUser
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody AuthUser authUser) {
        int num = authUserService.modify(authUser);
        return num;
    }

    /**
     * 通过主键ID删除用户表
     *
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        authUserService.remove(ids);
        return null;
    }

    /**
     * 用户注册
     *
     * @param authUserDto com.dk.auth.application.dto.AuthUserDto
     */
    @PostMapping("/register")
    public Result<Boolean> register(@Valid @RequestBody AuthUserDto authUserDto) {
        if (log.isInfoEnabled()) {
            log.info("AuthUserController.register.authUserDto: {}", authUserDto);
        }
        paramGeneralVerify(authUserDto);
        AuthUserBo authUserBo = AuthUserDTOConverter.INSTANCE.convertAuthUserBo(authUserDto);
        try {
            return Result.ok(authUserDomainService.register(authUserBo));
        } catch (Exception e) {
            log.error("AuthUserController.register，原因：{}", e.getMessage());
            return Result.fail("注册失败~");
        }
    }

    /**
     * 用户信息更新
     *
     * @param authUserDto com.dk.auth.application.dto.AuthUserDto
     */
    @PostMapping("/updateInfo")
    public Result<Boolean> updateInfo(@Valid @RequestBody AuthUserDto authUserDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("AuthUserController.updateInfo.authUserDto: {}", authUserDto);
            }
            Preconditions.checkNotNull(authUserDto.getId(), "用户ID不能为空~");
            paramGeneralVerify(authUserDto);
            AuthUserBo authUserBo = AuthUserDTOConverter.INSTANCE.convertAuthUserBo(authUserDto);
            return Result.ok(authUserDomainService.updateInfo(authUserBo));
        } catch (Exception e) {
            log.error("AuthUserController.updateInfo，原因：{}", e.getMessage());
            return Result.fail("注册失败，原因：" + e.getMessage());
        }
    }

    /**
     * 删除用户
     *
     * @param authUserDto com.dk.auth.application.dto.AuthUserDto
     */
    @PostMapping("/deleteUser")
    public Result<Boolean> deleteUser(@Valid @RequestBody AuthUserDto authUserDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("AuthUserController.deleteUser.authUserDto: {}", authUserDto);
            }
            Preconditions.checkNotNull(authUserDto.getId(), "用户ID不能为空~");
            AuthUserBo authUserBo = AuthUserDTOConverter.INSTANCE.convertAuthUserBo(authUserDto);
            return Result.ok(authUserDomainService.deleteUser(authUserBo));
        } catch (Exception e) {
            log.error("AuthUserController.updateInfo，原因：{}", e.getMessage());
            return Result.fail("注册失败，原因：" + e.getMessage());
        }
    }

    /**
     * 用户信息通用校验
     */
    private void paramGeneralVerify(AuthUserDto authUserDto) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(authUserDto.getUserName()), "用户名不能为空~");
        Preconditions.checkArgument(StringUtils.isNotEmpty(authUserDto.getPassword()), "密码不能为空~");
        Preconditions.checkArgument(StringUtils.isNotEmpty(authUserDto.getPhone()), "手机号不能为空~");
    }
}
