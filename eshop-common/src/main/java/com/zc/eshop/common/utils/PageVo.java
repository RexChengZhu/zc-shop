/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.zc.eshop.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页工具类
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
@NoArgsConstructor
public class PageVo<T>  {

	/**
	 * 总记录数
	 */
	private Integer totalCount;
	/**
	 * 每页记录数
	 */
	private Integer pageSize;
	/**
	 * 总页数
	 */
	private Integer totalPage;
	/**
	 * 当前页数
	 */
	private Integer currPage;
	/**
	 * 列表数据
	 */
	private List<T> list;

	public PageVo(IPage<T> page){
		this.list = page.getRecords();
		this.totalCount = (int) page.getTotal();
		this.pageSize =(int) page.getSize();
		this.currPage =(int) page.getCurrent();
		this.totalPage = (int)page.getPages();
	}

	public PageVo(PageReq req,Integer totalCount,List<T> list){
		this.currPage =  req.getCurrentPage();
		this.totalCount = totalCount;
		this.list = list;
	}



}
