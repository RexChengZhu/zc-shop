package com.zc.eshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.product.dao.AttrDao;
import com.zc.eshop.product.entity.AttrEntity;
import com.zc.eshop.product.service.AttrService;
import org.springframework.stereotype.Service;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {



}