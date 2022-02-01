package ru.gb.lesson4.repository;

import org.springframework.stereotype.Component;
import ru.gb.lesson4.entiry.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    List<Product> productList = new ArrayList<>();
    private int countId = 0;

    //конструктор, чтобы сразу создавалось 5 товаров
    public ProductRepository(){
        for(int i = 0; i < 5; i++){
            Product newProduct = new Product();
            newProduct.setId(countId);
            newProduct.setTitle("product"+countId);
            newProduct.setCost(String.format("%.0f", Math.random()*1000));
            productList.add(newProduct);
            countId++;
        }
    }

    //метод создания товара
    public Product save(Product product) {
     product.setId(countId);
     countId++;
     productList.add(product);
     return Product.builder()
             .id(product.getId())
             .title(product.getTitle())
             .cost(product.getCost())
             .build();
    }

    //поиск товара по id
    public Optional<Product> findById(Integer id){
        return Optional.of(productList.get(id));
    }

    //вывод всех товаров
    public List<Product> findAll(){
        return new ArrayList<>(productList);
    }

}
