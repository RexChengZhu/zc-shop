package com.zc.eshop.common.entity;

import com.zc.eshop.common.tree.TreeChild;
import com.zc.eshop.common.tree.TreeId;
import com.zc.eshop.common.tree.TreePid;
import com.zc.eshop.common.valid.product.AddCategory;
import com.zc.eshop.common.valid.product.UpdateCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Data

public class CategoryVo implements TreeChild<CategoryVo> {
    /**
     * 商品主键id
     */
    @TreeId
    @ApiModelProperty(value = "主键id",name = "id")
    @NotNull(groups = {UpdateCategory.class},message = "更新分类，id不能为空")
    @Null(groups = {AddCategory.class},message = "添加分类，id不能有值")
    private Integer id;
    /**
     * 父级商品的id
     */
    @TreePid
    @ApiModelProperty(value = "父级id",name = "pid")
    private Integer pid;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称",name = "name")
    @NotBlank(groups = {AddCategory.class,UpdateCategory.class},message = "分类名称不能为空")
    private String name;
    /**
     * 计量单位 （个，只，条）
     */
    @ApiModelProperty(value = "计量单位",name = "unit",example = "个，只")
    private String unit;
    /**
     * 图标地址
     */
    @ApiModelProperty(value = "图标地址",name = "avatar")
    private String avatar;
    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量",name = "count")
    private Integer count;
    /**
     * 层级
     */
    @ApiModelProperty(value = "层级",name = "catLevel")
    private Integer catLevel;
    /**
     * 是否显示[0-不显示，1显示]
     */
    @ApiModelProperty(value = "是否显示",name = "showStatus",allowableValues = "[0,1]")
    private Integer showStatus;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序",name = "sort")
    private Integer sort;

    /**
     * 子分类
     */
    private List<CategoryVo> subList = new ArrayList<>();


    @Override
    public List<CategoryVo> getChild() {
        return subList;
    }


}
