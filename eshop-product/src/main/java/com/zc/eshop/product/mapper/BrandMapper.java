package com.zc.eshop.product.mapper;

import com.zc.eshop.common.entity.BrandVo;
import com.zc.eshop.product.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BrandMapper {

    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    List<BrandVo> pos2vos(List<BrandEntity> list);


    @Mappings({
            @Mapping(target = "id", source = "brandId"),
    })
    BrandVo po2vo(BrandEntity list);

    @Mappings({
            @Mapping(source = "id", target = "brandId"),
    })
    BrandEntity vo2po(BrandVo vo);
}
