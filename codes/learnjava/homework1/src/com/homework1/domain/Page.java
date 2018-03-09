package com.homework1.domain;

import java.util.List;

public class Page<T> {
    //当前页的页码
    private int pageNow;
    //总页码数
    private int totalPages;
    //每页显示的记录数
    private int pageSize = 5;
    //总记录数
    private int totalRecords;
    //当前页的记录
    private List<T> list;

    public Page() {
    }

    public Page(int pageNow, int totalPages, int pageSize, int totalRecords, List<T> list) {
        this.pageNow = pageNow;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;
        this.list = list;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
