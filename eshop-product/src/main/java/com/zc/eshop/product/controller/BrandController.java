package com.zc.eshop.product.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.eshop.common.entity.BrandVo;
import com.zc.eshop.common.utils.PageReq;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.common.utils.Result;
import com.zc.eshop.common.valid.product.AddBrand;
import com.zc.eshop.common.valid.product.UpdateBrand;
import com.zc.eshop.product.entity.BrandEntity;
import com.zc.eshop.product.mapper.BrandMapper;
import com.zc.eshop.product.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


/**
 * 
 *
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:10:02
 */
@RestController
@RequestMapping("product/brand")
@Api(value = "品牌管理接口",tags = "品牌管理接口")
@Slf4j
public class BrandController {
    @Autowired
    private BrandService brandService;


    @PostMapping("/list")
    @ApiOperation(value = "获得品牌列表，分页结果")
    public Result<PageVo<BrandVo>> getList(@RequestBody PageReq<String> req){
        log.info("品牌列表查询请求，入参--{}", JSON.toJSONString(req));
        Page<BrandEntity> page = brandService.page(new Page<>(req.getCurrentPage(), req.getPageSize())
                , new QueryWrapper<BrandEntity>().likeRight(Objects.nonNull(req.getData()), "name", req.getData()));
        List<BrandVo> list = BrandMapper.INSTANCE.pos2vos(page.getRecords());
        return Result.ok(new PageVo<>(req,(int)page.getTotal(),list));
    }


    @PostMapping("/save")
    @ApiOperation(value = "新增品牌")
    public Result add(@Validated(AddBrand.class) @RequestBody BrandVo vo){
        log.info("收到新增品牌请求--{}",JSON.toJSONString(vo));
        brandService.save(BrandMapper.INSTANCE.vo2po(vo));
        return Result.ok(null);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改品牌")
    public Result update(@Validated(UpdateBrand.class) @RequestBody BrandVo vo){
        log.info("收到修改品牌请求--{}",JSON.toJSONString(vo));
        brandService.updateById(BrandMapper.INSTANCE.vo2po(vo));
        return Result.ok(null);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "根据id删除品牌")
    public Result delete(@RequestBody Long id){
        log.info("收到删除品牌请求--{}",id);
        brandService.removeById(id);
        return Result.ok(null);
    }

}
