package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PurchaseItemMapper {

    PurchaseProduct toPurchaseProduct(com.platzi.market.persistence.entity.PurchaseProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "purchase", ignore = true)
    })
    com.platzi.market.persistence.entity.PurchaseProduct toPurchaseProduct(PurchaseProduct product);
}
