package com.zc.eshop.product.controller;

import com.zc.eshop.product.service.AttrGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 
 *
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:10:02
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;



}
