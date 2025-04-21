package com.example.demo;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductReactiveService {
    public static Map<Long,Product> produits=new HashMap<>();
    Mono<Product> save(Product produit){
        produits.put(produit.getId(),produit);
        return Mono.justOrEmpty(produit);
    }
    Mono<Product> findById(Long id){
        return Mono.justOrEmpty(produits.get(id));
    }
    Flux<Product> findAll(){
        return Flux.fromIterable(produits.values());

    }
    Mono<Product> delete(Long id){
        Mono.justOrEmpty(produits.remove(id));
        return null;
    }
}
