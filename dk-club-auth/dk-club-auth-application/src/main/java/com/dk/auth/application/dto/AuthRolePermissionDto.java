package com.dk.auth.application.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色权限关系Dto
 * @author DEMOKING
 * @date 2025-04-15
 */
@Data
@Accessors(chain = true)
public class AuthRolePermissionDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 权限id列表
     */
    private List<Long> permissionIds;
}
