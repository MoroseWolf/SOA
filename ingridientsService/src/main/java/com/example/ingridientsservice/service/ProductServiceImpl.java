package com.example.ingridientsservice.service;

import com.example.ingridientsservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductServiceImpl implements  ProductService {

    // Хранилище клиентов
    private static final Map<Long, Product> PRODUCT_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID клиента
    private static final AtomicLong PRODUCT_ID_HOLDER = new AtomicLong();



    @Override
    public void create(Product product) {
        final Long productId = PRODUCT_ID_HOLDER.incrementAndGet();
        product.setId(productId);
        PRODUCT_REPOSITORY_MAP.put(productId, product);

    }

    @Override
    public List<Product> readAll() {
        return new ArrayList<>(PRODUCT_REPOSITORY_MAP.values());
    }

    @Override
    public Product read(Long id) {
        return PRODUCT_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Product product, Long id) {
        if (PRODUCT_REPOSITORY_MAP.containsKey(id)) {
            product.setId(id);
            PRODUCT_REPOSITORY_MAP.put(id, product);
            return true;
        }

        return false;
    }
}
