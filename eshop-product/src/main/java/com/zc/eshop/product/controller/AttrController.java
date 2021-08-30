package com.zc.eshop.product.controller;

import com.alibaba.spring.util.ObjectUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.eshop.common.entity.AttrQueryVo;
import com.zc.eshop.common.entity.AttrVo;
import com.zc.eshop.common.utils.ObjectUtil;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.common.utils.Result;
import com.zc.eshop.product.entity.AttrEntity;
import com.zc.eshop.product.entity.AttrGroupEntity;
import com.zc.eshop.product.mapper.AttrMapper;
import com.zc.eshop.product.service.AttrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


/**
 * 
 *
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:10:02
 */
@RestController
@RequestMapping("product/attr")
@Api(value = "属性关联接口", tags = "属性关联接口")
@Slf4j
public class AttrController {
    @Autowired
    private AttrService attrService;


    @PostMapping("/list")
    @ApiOperation("获得属性列表")
    public Result<PageVo<AttrVo>> list(@Validated @RequestBody AttrQueryVo req){
        PageVo<AttrVo> pageVo =  attrService.list(req);
        return Result.ok(pageVo);
    }

    @PostMapping("/save")
    @ApiOperation("保存属性")
    public Result save(@Validated @RequestBody AttrVo attrVo){
        attrService.save(attrVo);
        return Result.ok(null);
    }
}
