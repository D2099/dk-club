package com.dk.auth.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限关系表 实体类
 * @author DEMOKING
 * @date 2025-04-15
 */
@Data
@Accessors(chain = true)
@TableName("auth_role_permission")
public class AuthRolePermission implements Serializable {
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
     * 权限id
     */
    private Long permissionId;
    /**
     * 创建人
     */
    private Long createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private Long updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除 0: 未删除 1: 已删除
     */
    @TableLogic
    private Integer delFlag;
}
