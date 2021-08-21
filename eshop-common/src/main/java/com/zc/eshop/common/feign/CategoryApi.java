package com.zc.eshop.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eshop-product")
public interface CategoryApi {


    @GetMapping("api/wares/tcategory/test")
    String test();
}
