package com.zc.eshop.wares.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zc.eshop.common.entity.WaresCategoryVo;
import com.zc.eshop.common.utils.PageReq;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.wares.entity.TCategoryEntity;

/**
 * 
 *
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-06 20:56:08
 */
public interface TCategoryService extends IService<TCategoryEntity> {


    PageVo<WaresCategoryVo> getTreeList(PageReq<Integer> req);
}

