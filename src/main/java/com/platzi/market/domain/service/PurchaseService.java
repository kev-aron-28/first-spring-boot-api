package com.platzi.market.domain.service;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.respository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRespository;

    public List<Purchase> getAll() {
        return purchaseRespository.getAll();
    }

    public Optional<List<Purchase>> getById (int clientId) {
        return purchaseRespository.getByClientId(clientId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRespository.save(purchase);
    }
}
