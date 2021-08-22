package com.zc.eshop.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.eshop.common.entity.CategoryBrandRelationQueryVo;
import com.zc.eshop.common.entity.CategoryBrandRelationVo;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.common.utils.Result;
import com.zc.eshop.product.entity.CategoryBrandRelationEntity;
import com.zc.eshop.product.mapper.CategoryBrandRelationMapper;
import com.zc.eshop.product.service.CategoryBrandRelationService;
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


/**
 * 
 *
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:04:04
 */
@RestController
@RequestMapping("product/categorybrandrelation")
@Api(value = "品牌分类关联接口", tags = "品牌分类关联接口")
@Slf4j
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;


    @PostMapping("/list")
    @ApiOperation("根据品牌id获得该品牌下得所有关联分类")
    public Result<PageVo<CategoryBrandRelationVo>> getList(@Validated @RequestBody CategoryBrandRelationQueryVo queryVo){
        Page<CategoryBrandRelationEntity> page = categoryBrandRelationService.page(new Page<>(queryVo.getCurrentPage(), queryVo.getPageSize()),
                new QueryWrapper<CategoryBrandRelationEntity>().eq("brand_id", queryVo.getBrandId()));
        List<CategoryBrandRelationVo> list = CategoryBrandRelationMapper.INSTANCE.pos2vos(page.getRecords());
        return Result.ok(new PageVo<>(queryVo,(int)page.getTotal(),list));
    }


}
