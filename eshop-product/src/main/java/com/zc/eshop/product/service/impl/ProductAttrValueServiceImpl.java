package com.zc.eshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.product.dao.ProductAttrValueDao;
import com.zc.eshop.product.entity.ProductAttrValueEntity;
import com.zc.eshop.product.service.ProductAttrValueService;
import org.springframework.stereotype.Service;


@Service("productAttrValueService")
public class ProductAttrValueServiceImpl extends ServiceImpl<ProductAttrValueDao, ProductAttrValueEntity> implements ProductAttrValueService {



}