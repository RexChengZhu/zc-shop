package com.zc.eshop.wares.mapper;

import com.zc.eshop.common.entity.WaresCategoryVo;
import com.zc.eshop.wares.entity.TCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    WaresCategoryVo po2vo(TCategoryEntity entity);

    TCategoryEntity vo2po(WaresCategoryVo entity);
}
