package com.zc.eshop.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.common.entity.AttrQueryVo;
import com.zc.eshop.common.entity.AttrVo;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.product.dao.AttrAttrgroupRelationDao;
import com.zc.eshop.product.dao.AttrDao;
import com.zc.eshop.product.entity.AttrAttrgroupRelationEntity;
import com.zc.eshop.product.entity.AttrEntity;
import com.zc.eshop.product.entity.AttrGroupEntity;
import com.zc.eshop.product.entity.CategoryEntity;
import com.zc.eshop.product.mapper.AttrMapper;
import com.zc.eshop.product.service.AttrAttrgroupRelationService;
import com.zc.eshop.product.service.AttrGroupService;
import com.zc.eshop.product.service.AttrService;
import com.zc.eshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private AttrAttrgroupRelationDao attrAttrgroupRelationDao;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;
    /**
     * 保存属性 插入属性表 t_attr  并且关联属性分组表 t_attr_group_relation
     * @param attrVo
     */
    @Transactional
    @Override
    public void save(AttrVo attrVo) {
        AttrEntity attrEntity = AttrMapper.INSTANCE.vo2po(attrVo);
        baseMapper.insert(attrEntity);

        AttrAttrgroupRelationEntity relateEntity = new AttrAttrgroupRelationEntity();
        relateEntity.setAttrId(attrEntity.getAttrId());
        relateEntity.setAttrGroupId(attrVo.getGroupId());
        attrAttrgroupRelationDao.insert(relateEntity);
    }

    @Override
    public PageVo<AttrVo> list(AttrQueryVo req) {

        Page<AttrEntity> page = this.page(new Page<>(req.getCurrentPage(),req.getCurrentPage()), new QueryWrapper<AttrEntity>().eq(0 != req.getCatId(), "catelog_id", req.getCatId()));

        List<AttrVo> collect = page.getRecords().stream().map(item -> {
            AttrVo attrVo = AttrMapper.INSTANCE.po2vo(item);
            CategoryEntity category = categoryService.getById(item.getCatelogId());
            attrVo.setCatName(category.getName());

            AttrAttrgroupRelationEntity mid = attrAttrgroupRelationService.getOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", item.getAttrId()));
            AttrGroupEntity group = attrGroupService.getById(mid.getAttrGroupId());
            attrVo.setGroupName(group.getAttrGroupName());

            return attrVo;
        }).collect(Collectors.toList());
        return new PageVo<>(req,(int)page.getTotal(),collect);
    }
}