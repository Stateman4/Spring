package ru.gb.lesson10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson10.service.ProductInCartService;
import ru.gb.lesson10.entity.ProductInCart;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class ProductInCartController {
    private final ProductInCartService productInCartService;


    //показать все товары в корзине
    @GetMapping()
    public List<ProductInCart> getCartList(){
        return productInCartService.findAll();
    }

    //удалить товар из корзины
    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("productId") Long id){
        productInCartService.deleteById(id);
    }

}
