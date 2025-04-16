package com.dk.auth.application.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.dk.auth.domain.bo.AuthUserBo;
import com.dk.auth.domain.service.AuthUserDomainService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 用户登录
 */
@Slf4j
@RestController
@RequestMapping("/user/")
public class LoginController {

    @Resource
    private AuthUserDomainService authUserDomainService;

    // 用户登录  ---- http://localhost:8081/acc/doLogin?name=zhang&pwd=123456
    @RequestMapping("doLogin")
    public SaResult doLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        if (log.isInfoEnabled()) {
            log.info("LoginController.doLogin, username:{}, password:{}", username, password);
        }
        try {
            return authUserDomainService.login(username, password);
        } catch (Exception e) {
            log.error("登录失败，用户名：{} ，原因：{}", username, e.getMessage());
            return SaResult.error("登录失败~");
        }
    }

    // 查询登录状态  ---- http://localhost:8081/acc/isLogin
    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }
    
    // 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }
    
    // 测试注销  ---- http://localhost:8081/acc/logout
    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }
    
}
