package com.zc.eshop.wares.controller.api;

import com.zc.eshop.common.feign.CategoryApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/wares/tcategory")
public class CategoryApiController implements CategoryApi {


    @Override
    @GetMapping("/test")
    public String test() {
        return "ddddd";
    }
}
