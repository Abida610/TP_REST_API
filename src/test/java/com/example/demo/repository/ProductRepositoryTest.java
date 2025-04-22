package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindById_thenReturnProduct() {
        Product product = new Product("Tablet", 299.99);
        entityManager.persistAndFlush(product);

        Product found = productRepository.findById(product.getId()).orElse(null);
        assertThat(found.getName()).isEqualTo(product.getName());
    }
}