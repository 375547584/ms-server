package com.shenhai.tech.market.common.response;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    // 当前页。
    private long index = 0;
    // 每页显示的数据条数。
    private long total = 0L;

    // 每页显示的数据条数。
    private long pageSize = 0;
    // 页数
    private long pages = 0;

    // 数据
    private List<T> list;

    public PageBean() {
    }


    public PageBean(List<T> list, long total, int index) {
        this.index = index;
        this.total = total;
        this.list = list;
    }

    public PageBean(List<T> list, int index, int pages, long total) {
        this.index = index;
        this.total = total;
        this.pages = pages;
        this.list = list;
    }

    public PageBean(List<T> list, int index, int pages, int pageSize, int total) {
        this.index = index;
        this.total = total;
        this.pages = pages;
        this.pageSize = pageSize;
        this.list = list;
    }

    public PageBean(List<T> list, long index, long pages, long pageSize, long total) {
        this.list = list;
        this.index = index;
        this.pages = pages;
        this.pageSize = pageSize;
        this.total = total;
    }
}
