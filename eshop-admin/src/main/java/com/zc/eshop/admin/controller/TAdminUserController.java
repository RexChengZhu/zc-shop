package com.zc.eshop.admin.controller;

import com.zc.eshop.admin.entity.TAdminUserEntity;
import com.zc.eshop.admin.service.TAdminUserService;
import com.zc.eshop.common.feign.CategoryApi;
import com.zc.eshop.common.utils.PageVo;
import com.zc.eshop.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

@RefreshScope
@RestController
@RequestMapping("/admin/tadminuser")
public class TAdminUserController {

    @Autowired
    private CategoryApi categoryApi;


    @Autowired
    private TAdminUserService tAdminUserService;

    @Value("${admin.name}")
    private String name;


    @GetMapping("/test")
    public void test(){
        System.out.println(name);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageVo page = tAdminUserService.queryPage(params);

        return null;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
		TAdminUserEntity tAdminUser = tAdminUserService.getById(id);

        return null;
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody TAdminUserEntity tAdminUser){
		tAdminUserService.save(tAdminUser);

        return null;
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TAdminUserEntity tAdminUser){
		tAdminUserService.updateById(tAdminUser);

        return null;
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids){
		tAdminUserService.removeByIds(Arrays.asList(ids));

        return null;
    }

}
