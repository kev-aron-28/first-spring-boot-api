package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses={ PurchaseItemMapper.class })
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "products", target = "items")
    })
    Purchase toPurchase(com.platzi.market.persistence.entity.Purchase purchase);

    List<Purchase> toPurchases(List<com.platzi.market.persistence.entity.Purchase> purchases);
    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    com.platzi.market.persistence.entity.Purchase toPurchase(Purchase purchase);
}
