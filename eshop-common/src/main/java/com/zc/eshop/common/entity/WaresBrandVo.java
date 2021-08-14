package com.zc.eshop.common.entity;

import com.zc.eshop.common.valid.AddBrand;
import com.zc.eshop.common.valid.ListValue;
import com.zc.eshop.common.valid.UpdateBrand;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

@Data
public class WaresBrandVo {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", name = "id")
    @Null(message = "添加品牌Id不能填写",groups = {AddBrand.class})
    @NotNull(message = "更新品牌缺少id字段",groups = {UpdateBrand.class})
    private Integer id;
    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌名称", name = "name")
    @NotBlank(message = "品牌名称不能为空",groups = {AddBrand.class})
    private String name;
    /**
     * 品牌描述
     */
    @ApiModelProperty(value = "品牌描述", name = "desc")
    private String desc;
    /**
     * 品牌logo的OSS地址
     */
    @ApiModelProperty(value = "品牌logoUrl", name = "logoUrl")
    @URL(message = "请输入合法的url地址",groups = {AddBrand.class})
    private String logoUrl;
    /**
     * 状态 0 显示 1 不显示
     */
    @ApiModelProperty(value = "品牌状态", name = "status")
    @ListValue(values = {0,1},groups = {AddBrand.class})
    private Integer status;
    /**
     * 检索的首字母
     */
    @ApiModelProperty(value = "检索的首字母", name = "searchKey")
    @NotEmpty(groups = {AddBrand.class})
    @Pattern(regexp = "^[a-zA-Z]$",message = "检索名称必须是一个字母",groups = {AddBrand.class})

    private String searchKey;
}
