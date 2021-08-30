package com.zc.eshop.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:10:02
 */
@Data

public class AttrVo  {
	private static final long serialVersionUID = 1L;

	/**
	 * 属性id
	 */
	@ApiModelProperty(value = "主键id",name = "id")
	private Long id;
	/**
	 * 属性名
	 */
	@ApiModelProperty(value = "属性名",name = "attrName")

	private String attrName;

	/**
	 * 分类名称
	 */
	@ApiModelProperty(value = "分类名称",name = "catName")
	private String catName;

	/**
	 * 分组名称
	 */
	@ApiModelProperty(value = "分组名称",name = "groupName")
	private String groupName;


	/**
	 * 是否需要检索[0-不需要，1-需要]
	 */
	@ApiModelProperty(value = "是否需要检索",name = "searchType")
	private Integer searchType;
	/**
	 * 属性图标
	 */
	@ApiModelProperty(value = "属性图标",name = "icon")
	private String icon;
	/**
	 * 可选值列表[用逗号分隔]
	 */
	@ApiModelProperty(value = "可选值列表",name = "valueSelect")
	private List<String> valueSelect;
	/**
	 * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
	 */
	@ApiModelProperty(value = "属性类型",name = "attrType")
	private Integer attrType;
	/**
	 * 启用状态[0 - 禁用，1 - 启用]
	 */
	@ApiModelProperty(value = "启用状态",name = "enable")
	private Long enable;
	/**
	 * 所属分类
	 */
	@ApiModelProperty(value = "所属分类",name = "catelogId")
	private Long catelogId;
	/**
	 * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
	 */
	@ApiModelProperty(value = "快速展示",name = "showDesc")
	private Integer showDesc;

	/**
	 * 属性分组id
	 */
	@ApiModelProperty(value = "属性分组id",name = "groupId")
	private Long groupId;
}
