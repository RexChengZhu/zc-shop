package com.zc.eshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.product.dao.CategoryDao;
import com.zc.eshop.product.entity.CategoryEntity;
import com.zc.eshop.product.service.CategoryService;
import org.springframework.stereotype.Service;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {


}