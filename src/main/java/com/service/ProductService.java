package com.service;

import com.domain.Adminauthority;
import com.domain.Product;

import java.util.List;

public interface ProductService {

    public Product insert(Product product);

    public Product get(Long id);

    public List<Product> getAll();

    public Product update(Product product);

    public void delete(Long id);
}
