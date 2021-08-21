package com.zc.eshop.product.controller;

import com.zc.eshop.product.service.ProductAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 
 *
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:04:04
 */
@RestController
@RequestMapping("product/productattrvalue")
public class ProductAttrValueController {
    @Autowired
    private ProductAttrValueService productAttrValueService;


}
