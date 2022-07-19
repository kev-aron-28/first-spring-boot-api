package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.platzi.market.domain.respository.ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<com.platzi.market.domain.Product> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<com.platzi.market.domain.Product>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByCategoryId(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<com.platzi.market.domain.Product>> getShortStok(int stock) {
        Optional<List<Product>> products = productCrudRepository.findByStockLessThanAndStatus(stock, 1);
        return products.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<com.platzi.market.domain.Product> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public com.platzi.market.domain.Product save(com.platzi.market.domain.Product product) {
        Product prod = mapper.toProduct(product);
        return mapper.toProduct(productCrudRepository.save(prod));
    }
    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }

}
