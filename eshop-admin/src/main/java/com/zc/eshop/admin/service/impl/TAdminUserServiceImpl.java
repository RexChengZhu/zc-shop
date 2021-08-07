package com.zc.eshop.admin.service.impl;

import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zc.eshop.admin.dao.TAdminUserDao;
import com.zc.eshop.admin.entity.TAdminUserEntity;
import com.zc.eshop.admin.service.TAdminUserService;


@Service("tAdminUserService")
public class TAdminUserServiceImpl extends ServiceImpl<TAdminUserDao, TAdminUserEntity> implements TAdminUserService {

    @Override
    public PageVo queryPage(Map<String, Object> params) {
        IPage<TAdminUserEntity> page = this.page(
                new Query<TAdminUserEntity>().getPage(params),
                new QueryWrapper<TAdminUserEntity>()
        );

        return new PageVo(page);
    }

}