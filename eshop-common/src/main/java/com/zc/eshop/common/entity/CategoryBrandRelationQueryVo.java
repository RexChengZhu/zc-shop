package com.zc.eshop.common.entity;

import com.zc.eshop.common.utils.PageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 
 * 
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:04:04
 */
@Data
public class CategoryBrandRelationQueryVo extends PageReq<Object> {

	/**
	 * 品牌id
	 */
	@ApiModelProperty(value = "品牌id",name = "brandId")
	@NotNull(message = "品牌id不能为空")
	private Long brandId;



}
