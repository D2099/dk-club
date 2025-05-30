package com.dk.gateway.auth;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Sa-Token 权限认证] 配置类
 */
@Configuration
public class SaTokenConfigure {
    // 注册 Sa-Token全局过滤器 
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
            // 拦截地址 
            .addInclude("/**")
            // 开放地址 
            .addExclude("/favicon.ico")
            // 鉴权方法：每次访问进入
            .setAuth(obj -> {

                // 登录校验 -- 拦截所有路由，并排除/user/doLogin 用于开放登录 
                SaRouter.match("/**", "/auth/user/doLogin", r -> StpUtil.checkLogin());
                // SaRouter.match("/subject/subject-category/add", r -> StpUtil.checkPermission("subject:category:add"));
                SaRouter.match("/subject/subject-category/add", r -> StpUtil.checkPermission("subject:add"));
                // System.out.println("--------- flag 2，请求进入了拦截器，访问的 path 是：" + SaHolder.getRequest().getRequestPath());
                // 权限认证 -- 不同模块, 校验不同权限 
                // SaRouter.match("/user/**", r -> StpUtil.checkPermission("user"));
                // SaRouter.match("/admin/**", r -> StpUtil.checkPermission("admin"));
                // SaRouter.match("/goods/**", r -> StpUtil.checkPermission("goods"));
                // SaRouter.match("/orders/**", r -> StpUtil.checkPermission("orders"));
                
                // 更多匹配 ...  */
            });
    }
}
