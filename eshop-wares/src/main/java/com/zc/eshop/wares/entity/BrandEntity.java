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
 * @date 2021-08-14 13:15:37
 */
@Data
@TableName("t_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Integer id;
	/**
	 * 品牌名称
	 */
	private String name;
	/**
	 * 品牌描述
	 */
	private String detail;
	/**
	 * 品牌logo的OSS地址
	 */
	private String logoUrl;
	/**
	 * 状态 0 显示 1 不显示
	 */
	private Integer status;
	/**
	 * 检索的首字母
	 */
	private String searchKey;

}
