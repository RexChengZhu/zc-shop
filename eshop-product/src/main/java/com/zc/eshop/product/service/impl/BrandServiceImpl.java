package com.zc.eshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.product.dao.BrandDao;
import com.zc.eshop.product.entity.BrandEntity;
import com.zc.eshop.product.service.BrandService;
import org.springframework.stereotype.Service;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {



}