package com.zc.eshop.common.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 属性分组vo
 */
@Data
public class AttrGroupVo {

    /**
     * 分组id
     */
    @ApiModelProperty(value = "主键id",name = "id")
    private Long id;
    /**
     * 组名
     */
    @ApiModelProperty(value = "组名",name = "attrGroupName")
    private String attrGroupName;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序",name = "sort")
    private Integer sort;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述",name = "descript")
    private String descript;
    /**
     * 组图标
     */
    @ApiModelProperty(value = "组图标",name = "icon")
    private String icon;
    /**
     * 所属分类id
     */
    @ApiModelProperty(value = "所属分类id",name = "catId")
    private Long catId;

}