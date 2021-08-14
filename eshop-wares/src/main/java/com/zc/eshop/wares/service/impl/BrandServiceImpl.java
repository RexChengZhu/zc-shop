package com.zc.eshop.wares.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.common.entity.WaresBrandVo;
import com.zc.eshop.common.utils.PageReq;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.wares.dao.BrandDao;
import com.zc.eshop.wares.entity.BrandEntity;
import com.zc.eshop.wares.mapper.BrandMapper;
import com.zc.eshop.wares.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {


    @Override
    public PageVo<WaresBrandVo> queryList(PageReq<String> req) {

        Page<BrandEntity> page = this.page(new Page<>(req.calSkip(), req.getPageSize()), new QueryWrapper<BrandEntity>()
                .eq(Objects.nonNull(req.getData()), "name", req.getData()));
        List<WaresBrandVo> list = page.getRecords().stream().map(BrandMapper.INSTANCE::po2vo).collect(Collectors.toList());

        return new PageVo<>(req, (int) page.getTotal(), list);
    }

    @Override
    public void add(WaresBrandVo brandVo) {
        baseMapper.insert(BrandMapper.INSTANCE.vo2po(brandVo));
    }

    @Override
    public void deleteById(Integer id) {
        baseMapper.deleteById(id);
    }
}