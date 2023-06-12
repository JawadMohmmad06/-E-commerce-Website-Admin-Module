package com.repository;

import com.domain.Adminauthority;
import com.domain.Product;

import java.util.List;

public interface ProductRepository {

    public List<Product> getAll();

    public Product create(Product adminAuthority);

    public Product get(Long id);

    public Product update(Product adminAuthority);

    public void delete(Long id);
}
