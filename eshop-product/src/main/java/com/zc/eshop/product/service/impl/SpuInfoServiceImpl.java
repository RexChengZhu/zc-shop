package com.zc.eshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.product.dao.SpuInfoDao;
import com.zc.eshop.product.entity.SpuInfoEntity;
import com.zc.eshop.product.service.SpuInfoService;
import org.springframework.stereotype.Service;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {



}