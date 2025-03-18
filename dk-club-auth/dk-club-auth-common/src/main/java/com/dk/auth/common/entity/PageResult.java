package com.dk.auth.common.entity;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页返回实体
 */
@Data
public class PageResult<T> implements Serializable {

    @Setter
    private Integer currentPage = 1;

    @Setter
    private Integer pageSize = 20;

    private Integer total = 0;

    protected Integer totalPages = 0;

    protected List<T> result = Collections.emptyList();

    protected Integer start = 1;

    protected Integer end = 0;

    public void setRecords(List<T> result) {
        this.result = result;
        if (result != null && !result.isEmpty()) {
            setTotal(result.size());
        }
    }

    public void setTotal(Integer total) {
        this.total = total;
        if (this.pageSize > 0) {
            this.totalPages = (total / this.pageSize) + (total % this.pageSize == 0 ? 0 : 1);
        } else {
            this.totalPages = 0;
        }
        this.start = (this.pageSize > 0 ? (this.currentPage - 1) * this.pageSize : 0) + 1;
        this.end = (this.start - 1 + this.pageSize * (this.currentPage > 0 ? 1 : 0));
    }

}
