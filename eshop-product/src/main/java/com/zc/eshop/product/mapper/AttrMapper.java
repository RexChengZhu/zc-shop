package com.zc.eshop.product.mapper;

import com.zc.eshop.common.entity.AttrVo;
import com.zc.eshop.product.entity.AttrEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Mapper
public interface AttrMapper {

    AttrMapper INSTANCE = Mappers.getMapper(AttrMapper.class);


    List<AttrVo> pos2vos(List<AttrEntity> list);

    @Mappings({
            @Mapping(target = "attrId",source = "id")
    })
    AttrEntity vo2po(AttrVo vo);

    @Mappings({
            @Mapping(target = "id",source = "attrId")
    })
    AttrVo po2vo(AttrEntity vo);

    /**
     * mapstruct 会自动识别类型然后使用方法
     * @param src
     * @return
     */
    // str转list
    default List<String> str2List(String src){
        String[] split = src.split(",");
        List<String> result = Arrays.asList(split);
        return result;
    }

    // list转str
    default String list2Str(List<String> src){
        if (CollectionUtils.isEmpty(src)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        src.forEach(item -> sb.append(item).append(","));
        return sb.toString();
    }

}
