package com.zc.eshop.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 
 * 
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:04:04
 */
@Data
public class CategoryBrandRelationVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@ApiModelProperty(value = "主键id",name = "id")
	private Long id;
	/**
	 * 品牌id
	 */
	@ApiModelProperty(value = "品牌id",name = "brandId")
	@NotNull(message = "品牌id不能为空")
	private Long brandId;
	/**
	 * 分类id
	 */
	@ApiModelProperty(value = "分类id",name = "catelogId")
	@NotNull(message = "分类id不能为空")
	private Long catelogId;
	/**
	 * 品牌名称
	 */
	@ApiModelProperty(value = "品牌名称",name = "brandName")
	@NotNull(message = "品牌名称不能为空")
	private String brandName;
	/**
	 * 分类名称
	 */
	@ApiModelProperty(value = "分类名称",name = "catelogName")
	@NotNull(message = "分类名称不能为空")
	private String catelogName;

}
