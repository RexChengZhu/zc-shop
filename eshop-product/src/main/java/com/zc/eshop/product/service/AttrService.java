package com.zc.eshop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zc.eshop.common.entity.AttrQueryVo;
import com.zc.eshop.common.entity.AttrVo;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.product.entity.AttrEntity;

/**
 * 
 *
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:10:02
 */
public interface AttrService extends IService<AttrEntity> {


    void save(AttrVo attrVo);

    PageVo<AttrVo> list(AttrQueryVo req);
}

