package com.platzi.market.domain.respository;

import com.platzi.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClientId(int clientId);
    Purchase save(Purchase purchase);
}
