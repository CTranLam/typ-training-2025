package com.example.demo.Repository;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.Entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {
    private final Map<Long, ProductEntity> mapProduct = new HashMap<>();
    private Long countId = 1L;

    public List<ProductEntity> findAll() {
        return  new ArrayList<>(mapProduct.values());
    }

    public Optional<ProductEntity> findById(Long id) {
        return Optional.ofNullable(mapProduct.get(id));
    }

    public Optional<ProductEntity> findByName(String name) {
        return mapProduct.values().stream()
                .filter(p -> p.getProductName().equalsIgnoreCase(name))
                .findFirst();
    }

    public ProductEntity save(ProductEntity productEntity) {
        if(productEntity.getId() == 0){
            productEntity.setId(countId++);
        }
        mapProduct.put(productEntity.getId(), productEntity);
        return productEntity;
    }
    public void deleteById(Long id) {
        mapProduct.remove(id);
    }
}
