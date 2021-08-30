package com.zc.eshop.product.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.eshop.common.entity.AttrGroupQueryVo;
import com.zc.eshop.common.entity.AttrGroupVo;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.common.utils.Result;
import com.zc.eshop.product.entity.AttrGroupEntity;
import com.zc.eshop.product.mapper.AttrGroupMapper;
import com.zc.eshop.product.service.AttrGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


/**
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-21 15:10:02
 */
@Api(value = "属性分组管理接口", tags = "属性分组管理接口")
@Slf4j
@RestController
@RequestMapping("product/attrGroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;


    /**
     * 根据指定分类id查询数据，并且可以模糊查询
     *
     * @param req
     * @return
     */
    @PostMapping("/list")
    @ApiOperation(value = "属性分组列表，分页结果")
    public Result<PageVo<AttrGroupVo>> getList(@Validated @RequestBody AttrGroupQueryVo req) {
        log.info("收到查询属性分组列表请求,{}", JSON.toJSONString(req));
        Page<AttrGroupEntity> page;

        Page<AttrGroupEntity> queryPage = new Page<>(req.getCurrentPage(), req.getPageSize());

        if (StringUtils.isNotBlank(req.getKey())) {
            // SELECT * FROM t_attr_group where catelog_id = ? and (name like %?% or descript like %?% ）
            page = attrGroupService.page(queryPage, new QueryWrapper<AttrGroupEntity>().eq(Objects.nonNull(req.getCatId()),"catelog_id", req.getCatId()).
                    and(obj -> obj.eq("attr_group_id", req.getKey())
                            .or().like("attr_group_name", req.getKey())
                            .or().like("descript", req.getKey())));
        } else {
            page = attrGroupService.page(queryPage, new QueryWrapper<AttrGroupEntity>().eq(Objects.nonNull(req.getCatId()),"catelog_id", req.getCatId()));
        }

        List<AttrGroupVo> list = AttrGroupMapper.INSTANCE.pos2vos(page.getRecords());
        return Result.ok(new PageVo<>(req, (int) page.getTotal(), list));
    }


    @PostMapping("/save")
    @ApiOperation(value = "添加属性分组列表")
    public Result add(@Validated @RequestBody AttrGroupVo vo) {
        attrGroupService.save(AttrGroupMapper.INSTANCE.vo2po(vo));
        return Result.ok(null);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "根据id删除属性分组")
    public Result delete( @RequestBody Long id) {
        attrGroupService.removeById(id);
        return Result.ok(null);
    }
}
