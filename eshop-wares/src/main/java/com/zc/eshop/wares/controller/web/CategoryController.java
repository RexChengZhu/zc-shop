package com.zc.eshop.wares.controller.web;


import com.zc.eshop.common.entity.WaresCategoryVo;
import com.zc.eshop.common.utils.PageReq;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.common.utils.R;
import com.zc.eshop.wares.entity.TCategoryEntity;
import com.zc.eshop.wares.mapper.CategoryMapper;
import com.zc.eshop.wares.service.TCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-06 20:56:08
 */
@RestController
@RequestMapping("wares/category")
public class CategoryController {
    @Autowired
    private TCategoryService tCategoryService;


    /**
     * 列表
     * 根据pid 获得分类树型结构,一级分类传入的pid是0
     */
    @GetMapping("/list")
    @ApiOperation(value = "商品分类树列表")
    public R<PageVo<WaresCategoryVo>> list(PageReq<Integer> pageReq) {
        PageVo<WaresCategoryVo> pageVo = tCategoryService.getTreeList(pageReq);
        return R.ok(pageVo);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R<WaresCategoryVo> info(@PathVariable("id") Integer id) {
        TCategoryEntity tCategory = tCategoryService.getById(id);

        return R.ok(CategoryMapper.INSTANCE.po2vo(tCategory));
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody WaresCategoryVo tCategory) {

        tCategoryService.save(CategoryMapper.INSTANCE.vo2po(tCategory));
        return R.ok(null);

    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody WaresCategoryVo tCategory) {
        tCategoryService.updateById(CategoryMapper.INSTANCE.vo2po(tCategory));

        return R.ok(null);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids) {
        tCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok(null);
    }

}
