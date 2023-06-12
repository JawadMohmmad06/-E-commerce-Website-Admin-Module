package com.service;

import com.domain.Adminauthority;
import com.domain.Product;
import com.repository.AuthorityRepository;
import com.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductImplService  implements ProductService{

    private ProductRepository productRepository;

    public ProductImplService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product insert(Product product) {
        return productRepository.create(product);
    }

    @Transactional(readOnly = true)
    public Product get(Long id) {
        return productRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Transactional
    public Product update(Product product) {
        return productRepository.update(product);
    }

    @Transactional
    public void delete(Long id) {
        productRepository.delete(id);
    }
}
