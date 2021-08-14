package com.zc.eshop.wares.controller.web;

import com.zc.eshop.common.entity.WaresBrandVo;
import com.zc.eshop.common.utils.PageReq;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.common.utils.R;
import com.zc.eshop.common.valid.AddBrand;
import com.zc.eshop.wares.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-14 13:15:37
 */
@RestController
@RequestMapping("wares/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R<PageVo<WaresBrandVo>> queryList(PageReq<String> req) {
        PageVo<WaresBrandVo> page = brandService.queryList(req);
        return R.ok(page);
    }

    @PostMapping("/add")
    public R add(@Validated(value = AddBrand.class) @RequestBody WaresBrandVo brandVo){
         brandService.add(brandVo);
         return R.ok(null);
    }

    @PostMapping("/delete")
    public R del(@RequestBody Integer id){
        brandService.deleteById(id);
        return R.ok(null);
    }

}
