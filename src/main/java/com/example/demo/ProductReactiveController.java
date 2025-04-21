package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductReactiveController {
    @Autowired
    ProductReactiveService service;
    @RequestMapping(value="/product",method=RequestMethod.POST)
    public Mono<Product> create(@RequestBody Product produit){
        return service.save(produit);
    }
    @RequestMapping(value="/product/{id}",method=RequestMethod.GET)
    public Mono<Product> get(@PathVariable Long id){
        return service.findById(id);
    }

    @RequestMapping(value="/product/{id}",method=RequestMethod.PUT)
    public Mono<Product> update(@PathVariable Long id,@RequestBody Product product)
    {
        product.setId(id);
        return service.save(product);
    }
    @RequestMapping(value="/product/{id}",method=RequestMethod.DELETE)
    public Mono<Product> delete(@PathVariable Long id){
        return service.delete(id);
    }
    @RequestMapping(value="/product",method=RequestMethod.GET)
    public Flux<Product> getAll(){
        return service.findAll();
    }
}
