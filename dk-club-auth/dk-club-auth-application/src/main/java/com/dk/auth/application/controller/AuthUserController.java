package com.dk.auth.application.controller;

import com.dk.auth.application.convert.AuthUserDTOConverter;
import com.dk.auth.application.dto.AuthUserDto;
import com.dk.auth.common.entity.Result;
import com.dk.auth.domain.bo.AuthUserBo;
import com.dk.auth.domain.service.AuthUserDomainService;
import com.dk.auth.infra.basic.entity.AuthUser;
import com.dk.auth.infra.basic.service.AuthUserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户表 接口控制器
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
     * @param authUser com.dk.auth.infra.basic.entity.AuthUser
     */
    @PostMapping("/add")
    public Object add(@Valid @RequestBody AuthUser authUser) {
        authUserService.add(authUser);
        return null;
    }

    /**
     * 更新用户表
     * @param  authUser com.dk.auth.infra.basic.entity.AuthUser
     */
    @PutMapping("/update")
    public int update(@Valid @RequestBody AuthUser authUser) {
        int num = authUserService.modify(authUser);
        return num;
    }

    /**
     * 通过主键ID删除用户表
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        authUserService.remove(ids);
        return null;
    }

    /**
     * 用户注册
     * @param authUserDto com.dk.auth.application.dto.AuthUserDto
     */
    @PostMapping("/register")
    public Result<Boolean> register(@Valid @RequestBody AuthUserDto authUserDto) {
        if (log.isInfoEnabled()) {
            log.info("AuthUserController.register.authUserDto: {}", authUserDto);
        }
        AuthUserBo authUserBo = AuthUserDTOConverter.INSTANCE.convertAuthUserBo(authUserDto);
        try {
            return Result.ok(authUserDomainService.register(authUserBo));
        } catch (Exception e) {
            log.error("AuthUserController.register，原因：{}", e.getMessage());
            return Result.fail("注册失败~");
        }
    }
}
