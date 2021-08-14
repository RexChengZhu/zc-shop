package com.zc.eshop.wares.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zc.eshop.common.entity.WaresBrandVo;
import com.zc.eshop.common.utils.PageReq;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.wares.entity.BrandEntity;

/**
 * 
 *
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-14 13:15:37
 */
public interface BrandService extends IService<BrandEntity> {


    PageVo<WaresBrandVo> queryList(PageReq<String> req);

    void add(WaresBrandVo brandVo);

    void deleteById(Integer id);

}

