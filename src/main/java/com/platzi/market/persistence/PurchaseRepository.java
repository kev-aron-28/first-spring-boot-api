package com.platzi.market.persistence;

import com.platzi.market.domain.Purchase;
import com.platzi.market.persistence.crud.PurchaseCrudRepository;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements com.platzi.market.domain.respository.PurchaseRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper
                .toPurchases((List<com.platzi.market.persistence.entity.Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClientId(int clientId) {
        return purchaseCrudRepository.findByClientId(clientId)
                .map(purchases -> mapper.toPurchases(purchases));
    }

    @Override
    public Purchase save(Purchase purchase) {
        com.platzi.market.persistence.entity.Purchase purchaseEntity = mapper.toPurchase(purchase);
        purchaseEntity.getProducts().forEach(purchaseProduct -> purchaseProduct.setPurchase(purchaseEntity));
        return mapper.toPurchase(purchaseCrudRepository.save(purchaseEntity));
    }
}
