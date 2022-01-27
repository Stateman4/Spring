package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.entiry.Product;
import ru.gb.repository.ProductRepository;

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

    //метод поиска по id
    public Product findById(Integer id){
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    //метод поиска всех товаров
    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
