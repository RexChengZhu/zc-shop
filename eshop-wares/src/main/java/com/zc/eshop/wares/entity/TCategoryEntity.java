package com.zc.eshop.wares.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-06 20:56:08
 */
@Data
@TableName("t_category")
public class TCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品主键id
	 */
	@TableId
	private Integer id;
	/**
	 * 父级商品的id
	 */
	private Integer pid;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 计量单位 （个，只，条）
	 */
	private String unit;
	/**
	 * 图标地址
	 */
	private String avatar;
	/**
	 * 商品数量
	 */
	private Integer count;

}
