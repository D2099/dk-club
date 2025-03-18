package com.dk.auth.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页信息封装类
 */
@Data
public class PageInfo implements Serializable {

    private Integer currentPage;

    private Integer pageSize;

    private Integer start;

    public PageInfo() {
    }

    public PageInfo (Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.start = (getCurrentPage() - 1) * getPageSize();
    }

    public Integer getCurrentPage() {
        if (currentPage == null || currentPage < 1) {
            return 1;
        }
        return currentPage;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1) {
            return 20;
        }
        return pageSize;
    }
}
