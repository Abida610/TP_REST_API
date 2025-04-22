/*package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;
    @GetMapping
    public List<Product> getAll(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }
    @PostMapping
    public Product create(@RequestBody Product product){
        return repository.save(product);
    }
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,@RequestBody Product product)
    {
        product.setId(id);
        return repository.save(product);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
}
*/