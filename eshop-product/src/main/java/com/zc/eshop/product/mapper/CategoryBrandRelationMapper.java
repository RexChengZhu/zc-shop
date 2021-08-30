package com.zc.eshop.product.mapper;

import com.zc.eshop.common.entity.CategoryBrandRelationVo;
import com.zc.eshop.product.entity.CategoryBrandRelationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryBrandRelationMapper {

    CategoryBrandRelationMapper INSTANCE = Mappers.getMapper(CategoryBrandRelationMapper.class);

    List<CategoryBrandRelationVo> pos2vos(List<CategoryBrandRelationEntity> list);

    List<CategoryBrandRelationEntity> vos2pos(List<CategoryBrandRelationVo> list);

}
