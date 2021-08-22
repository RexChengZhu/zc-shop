package com.zc.eshop.product.mapper;

import com.zc.eshop.common.entity.AttrGroupVo;
import com.zc.eshop.product.entity.AttrGroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AttrGroupMapper {

    AttrGroupMapper INSTANCE = Mappers.getMapper(AttrGroupMapper.class);

    List<AttrGroupVo> pos2vos(List<AttrGroupEntity> list);


    @Mappings({
            @Mapping(target = "id", source = "attrGroupId"),
            @Mapping(target = "catId", source = "catelogId"),
    })
    AttrGroupVo po2vo(AttrGroupEntity list);

    @Mappings({
            @Mapping(source = "id", target = "attrGroupId"),
            @Mapping(source = "catId", target = "catelogId"),

    })
    AttrGroupEntity vo2po(AttrGroupVo vo);
}
