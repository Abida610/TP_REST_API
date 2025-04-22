package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void whenSaveProduct_shouldReturnProduct() {
        Product product = new Product("Laptop", 999.99);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product created = productService.save(product);
        assertNotNull(created);
        assertEquals("Laptop", created.getName());
    }

    @Test
    public void whenGivenId_shouldReturnProduct_ifFound() {
        Product product = new Product(1L, "Phone", 599.99);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product found = productService.findById(1L);
        assertAll(
                () -> assertNotNull(found),
                () -> assertEquals("Phone", found.getName())
        );
    }
}