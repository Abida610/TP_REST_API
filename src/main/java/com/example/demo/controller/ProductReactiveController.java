package com.example.demo.controller;

import com.example.demo.repository.ProductReactiveRepository;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductReactiveController {
    @Autowired
    ProductReactiveRepository service;
    @RequestMapping(value="/api/products",method=RequestMethod.POST)
    public Mono<Product> create(@RequestBody Product produit){
        return service.save(produit);
    }
    @RequestMapping(value="/api/products/{id}",method=RequestMethod.GET)
    public Mono<Product> get(@PathVariable Long id){
        return service.findById(id);
    }

    @RequestMapping(value="/api/products/{id}",method=RequestMethod.PUT)
    public Mono<Product> update(@PathVariable Long id,@RequestBody Product product)
    {
        product.setId(id);
        return service.save(product);
    }
    @RequestMapping(value="/api/products/{id}",method=RequestMethod.DELETE)
    public Mono<Product> delete(@PathVariable Long id){
        return service.delete(id);
    }
    @RequestMapping(value="/api/products",method=RequestMethod.GET)
    public Flux<Product> getAll(){
        return service.findAll();
    }
}
