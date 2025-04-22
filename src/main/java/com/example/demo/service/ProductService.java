package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;


    public List<Product> findAll()
    {
        return repository.findAll();
    }

    public Product findById(Long id){
        return repository.findById(id).orElse(null);
    }
    public Product save(Product product){
        return repository.save(product);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
