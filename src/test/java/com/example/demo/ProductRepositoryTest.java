package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RestApiApplication.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repo;

    @Test
    public void testRepository() {

        Product produit = new Product();
        produit.setName("Pc");
        produit.setPrice(5222.0);
        Product savedProduct = repo.save(produit);

        Assert.assertNotNull(savedProduct.getId());
        Assert.assertEquals("Pc", savedProduct.getName());
        Assert.assertEquals(5222.0, savedProduct.getPrice(),0.01);

    }
}
