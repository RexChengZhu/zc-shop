package com.zc.eshop.common.entity;


import com.zc.eshop.common.utils.PageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 属性分组vo
 */
@Data
public class AttrGroupQueryVo extends PageReq<Object> {

    @ApiModelProperty(value = "分类id",name = "catId")
    private Long catId;

    @ApiModelProperty(value = "查询关键字",name = "key")
    private String key;
}