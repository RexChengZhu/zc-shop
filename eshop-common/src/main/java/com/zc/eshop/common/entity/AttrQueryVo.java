package com.zc.eshop.common.entity;

import com.zc.eshop.common.utils.PageReq;
import lombok.Data;

@Data
public class AttrQueryVo extends PageReq {
    private Long catId = 0L;

    private String name;

}
