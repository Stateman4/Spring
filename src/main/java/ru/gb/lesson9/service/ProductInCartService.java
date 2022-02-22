package ru.gb.lesson9.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.lesson9.entity.ProductInCart;
import ru.gb.lesson9.repository.ProductInCartRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductInCartService {
    private final ProductInCartRepository productInCartRepository;

    //метод создания продукта
    public ProductInCart save(Long id){
      return productInCartRepository.save(id);
    }

    //метод поиска всех товаров
    public List<ProductInCart> findAll(){
        return productInCartRepository.findAll();
    }

    //метод удаления товара
    public void deleteById(Long id){
        productInCartRepository.deleteById(id);
    }

}
