package ru.gb.lesson10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.gb.lesson10.dto.ProductDto;
import ru.gb.lesson10.entity.Product;
import ru.gb.lesson10.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    //метод создания продукта
    public ProductDto save(ProductDto productDto){
        return productRepository.save(productDto);
    }
////
//    //метод поиска по id
    public Product findById(Long id){
        return productRepository.findById(id);
    }

    //метод поиска всех товаров
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    //метод поиска всех товаров с сортировкой
    public List<Product> findAllSort(Sort.Direction direction){
        return productRepository.findAllSort(direction);
    }

    //метод удаления товара
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

}
