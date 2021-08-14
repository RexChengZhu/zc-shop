package com.zc.eshop.wares.mapper;

import com.zc.eshop.common.entity.WaresBrandVo;
import com.zc.eshop.wares.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {

    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    @Mapping(source = "detail",target = "desc")
    WaresBrandVo po2vo(BrandEntity entity);

    @Mapping(source = "desc",target = "detail")
    BrandEntity vo2po(WaresBrandVo entity);
}
