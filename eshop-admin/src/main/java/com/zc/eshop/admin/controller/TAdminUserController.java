package com.zc.eshop.admin.controller;

import com.zc.eshop.admin.entity.TAdminUserEntity;
import com.zc.eshop.admin.service.TAdminUserService;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-01 16:38:08
 */
@RestController
@RequestMapping("/admin/tadminuser")
public class TAdminUserController {
    @Autowired
    private TAdminUserService tAdminUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageVo page = tAdminUserService.queryPage(params);

        return null;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		TAdminUserEntity tAdminUser = tAdminUserService.getById(id);

        return null;
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TAdminUserEntity tAdminUser){
		tAdminUserService.save(tAdminUser);

        return null;
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TAdminUserEntity tAdminUser){
		tAdminUserService.updateById(tAdminUser);

        return null;
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		tAdminUserService.removeByIds(Arrays.asList(ids));

        return null;
    }

}
