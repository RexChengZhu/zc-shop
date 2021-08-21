package com.zc.eshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.product.dao.SkuImagesDao;
import com.zc.eshop.product.entity.SkuImagesEntity;
import com.zc.eshop.product.service.SkuImagesService;
import org.springframework.stereotype.Service;


@Service("skuImagesService")
public class SkuImagesServiceImpl extends ServiceImpl<SkuImagesDao, SkuImagesEntity> implements SkuImagesService {


}