package com.zc.eshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.product.dao.SkuInfoDao;
import com.zc.eshop.product.entity.SkuInfoEntity;
import com.zc.eshop.product.service.SkuInfoService;
import org.springframework.stereotype.Service;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

}