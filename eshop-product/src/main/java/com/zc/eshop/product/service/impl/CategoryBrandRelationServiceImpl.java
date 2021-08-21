package com.zc.eshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.product.dao.CategoryBrandRelationDao;
import com.zc.eshop.product.entity.CategoryBrandRelationEntity;
import com.zc.eshop.product.service.CategoryBrandRelationService;
import org.springframework.stereotype.Service;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {


}