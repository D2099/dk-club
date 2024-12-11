package com.dk.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
* 题目分类
* @author lxb
* @date 2024-12-10
*/
@Data
@Accessors(chain = true)
@TableName("subject_category")
public class SubjectCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    * 主键
    */
    private Long id;
    /**
    * 分类名称
    */
    private String categoryName;
    /**
    * 分类类型
    */
    private Integer categoryType;
    /**
    * 图标连接
    */
    private String imageUrl;
    /**
    * 父级id
    */
    private Long parentId;
    /**
    * 创建人
    */
    private String createdBy;
    /**
    * 创建时间
    */
    private Date createdTime;
    /**
    * 更新人
    */
    private String updateBy;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 是否删除 0: 未删除 1: 已删除
    */
    private Boolean delFlag;
}
