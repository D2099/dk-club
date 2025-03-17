package com.dk.gateway.auth;

import cn.dev33.satoken.stp.StpInterface;
import com.dk.gateway.redis.RedisUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 自定义权限验证接口扩展 
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    private String premissionPrefix = "auth.permission";

    private String rolePrefix = "auth.role";

    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的权限列表
        return getAuth(premissionPrefix, loginId);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的角色列表
        return getAuth(rolePrefix, loginId);
    }

    /**
     * 获取用户认证权限或角色
     * @param prefix
     * @param userId
     * @return
     */
    private List<String> getAuth(String prefix, Object userId) {
        String buildKey = redisUtil.buildKey(prefix, String.valueOf(userId));
        String value = redisUtil.get(buildKey);
        if (StringUtils.isEmpty(value)) {
            return Collections.emptyList();
        }
        return new Gson().fromJson(value, List.class);
    }
}
