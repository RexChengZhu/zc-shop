package com.zc.eshop.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zc.eshop.admin.entity.TAdminUserEntity;
import com.zc.eshop.common.utils.PageVo;

import java.util.Map;

/**
 * 
 *
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-01 16:38:08
 */
public interface TAdminUserService extends IService<TAdminUserEntity> {

    PageVo queryPage(Map<String, Object> params);
}

