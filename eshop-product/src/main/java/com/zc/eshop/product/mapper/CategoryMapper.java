package com.zc.eshop.product.mapper;

import com.zc.eshop.common.entity.CategoryVo;
import com.zc.eshop.product.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    List<CategoryVo> pos2vos(List<CategoryEntity> list);


    @Mappings({
            @Mapping(target = "id", source = "catId"),
            @Mapping(target = "pid", source = "parentCid"),
            @Mapping(target = "avatar", source = "icon"),
            @Mapping(target = "count", source = "productCount"),
            @Mapping(target = "unit", source = "productUnit")
    })
    CategoryVo po2vo(CategoryEntity list);

    @Mappings({
            @Mapping(source = "id", target = "catId"),
            @Mapping(source = "pid", target = "parentCid"),
            @Mapping(source = "avatar", target = "icon"),
            @Mapping(source = "count", target = "productCount"),
            @Mapping(source = "unit", target = "productUnit")
    })
    CategoryEntity vo2po(CategoryVo vo);
}
