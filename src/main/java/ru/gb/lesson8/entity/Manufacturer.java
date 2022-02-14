package ru.gb.lesson8.entity;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Manufacturer {
    private long id;
    private String name;
    private Set<Product> products;

    public boolean addProduct(Product product){
        if(products == null){
            products = new HashSet<>();
        }
        return products.add(product);
    }
 }
