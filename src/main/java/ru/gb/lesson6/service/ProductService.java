package ru.gb.lesson6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.lesson6.entity.Product;
import ru.gb.lesson6.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    //метод создания продукта
    public Product save(Product product){
        return productRepository.save(product);
    }
//
    //метод поиска по id
    public Product findById(Long id){
        return productRepository.findById(id);
    }

    //метод поиска всех товаров
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    //метод удаления товара
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

}
