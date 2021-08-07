package com.zc.eshop.common.entity;

import com.zc.eshop.common.tree.TreeChild;
import com.zc.eshop.common.tree.TreeId;
import com.zc.eshop.common.tree.TreePid;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class WaresCategoryVo implements TreeChild<WaresCategoryVo> {
    /**
     * 商品主键id
     */
    @TreeId
    @ApiModelProperty(value = "主键id",name = "id")
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
     * 子分类
     */
    private List<WaresCategoryVo> subList = new ArrayList<>();


    @Override
    public List<WaresCategoryVo> getChild() {
        return subList;
    }


}
