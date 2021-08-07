package com.zc.eshop.common.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 前端分页查询时的参数
 */
@Data
public class PageReq<T> {

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页",name = "currentPage")
    private Integer currentPage = 1;
    /**
     * 每页多少条数据
     */
    @ApiModelProperty(value = "每页多少条数据",name = "pageSize")
    private Integer pageSize = 10;

    private T data;

    public Integer calSkip(){
        return (currentPage-1) * pageSize;
    }

}
