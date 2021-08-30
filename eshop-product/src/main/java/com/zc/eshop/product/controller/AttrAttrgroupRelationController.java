package com.zc.eshop.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zc.eshop.common.entity.AttrVo;
import com.zc.eshop.common.utils.Result;
import com.zc.eshop.product.entity.AttrAttrgroupRelationEntity;
import com.zc.eshop.product.mapper.AttrMapper;
import com.zc.eshop.product.service.AttrAttrgroupRelationService;
import com.zc.eshop.product.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:10:02
 */
@RestController
@RequestMapping("product/attrattrgrouprelation")
public class AttrAttrgroupRelationController {
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @Autowired
    private AttrService attrService;


    @GetMapping("/list")
    public Result<List<AttrVo>> list(Long id) {
        List<AttrAttrgroupRelationEntity> list = attrAttrgroupRelationService.list(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_group_id", id));
        List<AttrVo> collect = list.stream().map(item ->
                attrService.getById(item.getAttrId())
        ).map(AttrMapper.INSTANCE::po2vo).collect(Collectors.toList());
        return Result.ok(collect);
    }

//    @PostMapping("/save")
//    public Result save(@RequestBody AttrAttrgroupRelationVo vo) {
//        attrAttrgroupRelationService.save(AttrGroupRelationMapper.INSTANCE.vo2po(vo));
//        return Result.ok(null);
//    }

}
