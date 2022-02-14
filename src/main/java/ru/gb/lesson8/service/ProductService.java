package ru.gb.lesson8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.gb.lesson8.entity.Product;
import ru.gb.lesson8.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    //метод создания продукта
    public Product save(Product product){
        return productRepository.save(product);
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
