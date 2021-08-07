package com.zc.eshop.wares.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.common.entity.WaresCategoryVo;
import com.zc.eshop.common.tree.TreeMaker;
import com.zc.eshop.common.utils.PageReq;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.wares.dao.TCategoryDao;
import com.zc.eshop.wares.entity.TCategoryEntity;
import com.zc.eshop.wares.mapper.CategoryMapper;
import com.zc.eshop.wares.service.TCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("tCategoryService")
public class TCategoryServiceImpl extends ServiceImpl<TCategoryDao, TCategoryEntity> implements TCategoryService {


    /**
     * 把分类全部查询出来之后，生成树结构找到需要查询pid的返回
     * @param req  带有分页性质的查询条件
     * @return 分页结构的树
     */
    @Override
    public PageVo<WaresCategoryVo> getTreeList(PageReq<Integer> req) {
        List<TCategoryEntity> list = baseMapper.selectList(null);
        List<WaresCategoryVo> collect = list.stream().map(CategoryMapper.INSTANCE::po2vo).collect(Collectors.toList());
        List<WaresCategoryVo> tree = new TreeMaker<WaresCategoryVo>().build(collect);
        List<WaresCategoryVo> pg = tree.stream().skip(req.calSkip())
                .limit(req.getPageSize()).collect(Collectors.toList());
        return new PageVo<>(req, tree.size(),pg);
    }


}