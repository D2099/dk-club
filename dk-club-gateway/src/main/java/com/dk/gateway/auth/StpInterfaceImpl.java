package com.dk.gateway.auth;

import cn.dev33.satoken.stp.StpInterface;
import com.dk.gateway.entity.AuthPermission;
import com.dk.gateway.entity.AuthRole;
import com.dk.gateway.redis.RedisUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

    private String permissionPrefix = "auth.permission";

    private String rolePrefix = "auth.role";

    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的权限列表
        return getAuth(permissionPrefix, loginId);
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
        if (!StringUtils.isEmpty(value)) {
            if ("auth.role".equals(prefix)) {
                List<AuthRole> roleList = new Gson().fromJson(value, new TypeToken<List<AuthRole>>(){}.getType());
                return roleList.stream().map(AuthRole::getRoleKey).toList();
            }
            if ("auth.permission".equals(prefix)) {
                List<AuthPermission> permissionList = new Gson().fromJson(value, new TypeToken<List<AuthPermission>>(){}.getType());
                return permissionList.stream().map(AuthPermission::getPermissionKey).toList();
            }
        }
        return Collections.emptyList();
    }
}
