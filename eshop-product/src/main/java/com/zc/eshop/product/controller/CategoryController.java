package com.zc.eshop.product.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.eshop.common.entity.CategoryVo;
import com.zc.eshop.common.tree.TreeMaker;
import com.zc.eshop.common.utils.PageReq;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.common.utils.R;
import com.zc.eshop.common.valid.product.AddCategory;
import com.zc.eshop.common.valid.product.UpdateCategory;
import com.zc.eshop.product.entity.CategoryEntity;
import com.zc.eshop.product.mapper.CategoryMapper;
import com.zc.eshop.product.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;


/**
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:10:02
 */
@RestController
@RequestMapping("product/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/list")
    @ApiOperation("根据pid查询分类列表")
    public R<PageVo<CategoryVo>> getList(@RequestBody PageReq<Integer> req) {
        log.info("分类查询列表收到请求，{}", JSON.toJSONString(req));
        Page<CategoryEntity> queryPage = new Page<>();
        Page<CategoryEntity> page = categoryService.page(queryPage, new QueryWrapper<CategoryEntity>().eq(Objects.nonNull(req.getData()), "parent_cid", req.getData()));
        List<CategoryVo> voList = CategoryMapper.INSTANCE.pos2vos(page.getRecords()); // page.getRecords().stream().map(CategoryMapper.INSTANCE::pos2vos).collect(Collectors.toList());
        return R.ok(new PageVo<>(req, (int) page.getTotal(), voList));
    }

    @PostMapping("/tree")
    @ApiOperation("获得所有分类的树")
    public R<List<CategoryVo>> getTree() {
        List<CategoryEntity> list = categoryService.list(null);
        List<CategoryVo> voList = CategoryMapper.INSTANCE.pos2vos(list);
        List<CategoryVo> tree = new TreeMaker<CategoryVo>().build(voList);
        return R.ok(tree);
    }

    @PostMapping("/save")
    @ApiOperation("添加分类")
    public R add(
            @Validated(AddCategory.class)
            @RequestBody CategoryVo vo) {
        categoryService.save(CategoryMapper.INSTANCE.vo2po(vo));
        return R.ok(null);
    }

    @PostMapping("/update")
    @ApiOperation("更新分类")
    public R update(@Validated(UpdateCategory.class) @RequestBody CategoryVo vo) {
        categoryService.updateById(CategoryMapper.INSTANCE.vo2po(vo));
        return R.ok(null);
    }

    @PostMapping("/delete")
    @ApiOperation("删除分类")
    public R del(@NotNull(message = "删除分类id不能为空") @RequestBody Integer id) {
        categoryService.removeById(id);
        return R.ok(null);
    }
}
