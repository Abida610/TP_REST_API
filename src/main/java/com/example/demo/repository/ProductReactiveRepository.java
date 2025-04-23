package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductReactiveRepository {
    public static Map<Long, Product> produits=new HashMap<>();
    public Mono<Product> save(Product produit){
        produits.put(produit.getId(),produit);
        return Mono.justOrEmpty(produit);
    }
    public Mono<Product> findById(Long id){
        return Mono.justOrEmpty(produits.get(id));
    }
    public Flux<Product> findAll(){
        return Flux.fromIterable(produits.values());

    }
    public Mono<Product> delete(Long id){
        Mono.justOrEmpty(produits.remove(id));
        return null;
    }
}
