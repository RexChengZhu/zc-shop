package com.zc.eshop.common.entity;

import com.zc.eshop.common.valid.product.AddBrand;
import com.zc.eshop.common.valid.product.UpdateBrand;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 品牌vo
 */
@Data
public class BrandVo  {

    /**
     * 品牌id
     */
    @ApiModelProperty(value = "主键id",name = "id")
    @NotNull(groups = UpdateBrand.class,message = "编辑品牌，id不能为空")
    @Null(groups = AddBrand.class,message = "新增品牌，id不能有值")
    private Long id;
    /**
     * 品牌名
     */
    @ApiModelProperty(value = "品牌名",name = "name")
    @NotBlank(groups = {AddBrand.class,UpdateBrand.class},message = "品牌名称不能为空")
    private String name;
    /**
     * 品牌logo地址
     */
    @ApiModelProperty(value = " 品牌logo地址",name = "logo")
    private String logo;
    /**
     * 介绍
     */
    @ApiModelProperty(value = " 介绍",name = "descript")
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
    @ApiModelProperty(value = " 显示状态",name = "showStatus",allowableValues = "[0,1]")
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @ApiModelProperty(value = " 检索首字母",name = "firstLetter")
    private String firstLetter;
    /**
     * 排序
     */
    @ApiModelProperty(value = " 排序",name = "sort")
    private Integer sort;



}
