package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "status", target = "active"),
    })
    Product toProduct(com.platzi.market.persistence.entity.Product product);

    List<Product> toProducts(List<com.platzi.market.persistence.entity.Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode",ignore = true)
    com.platzi.market.persistence.entity.Product toProduct(Product product);
}
