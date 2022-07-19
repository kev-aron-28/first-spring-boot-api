package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "description", target = "category"),
    })
    Category toCategory(com.platzi.market.persistence.entity.Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    com.platzi.market.persistence.entity.Category toCategory(Category category);

}
