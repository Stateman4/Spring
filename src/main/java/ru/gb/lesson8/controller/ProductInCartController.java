package ru.gb.lesson8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson8.service.ProductInCartService;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class ProductInCartController {
    private final ProductInCartService productInCartService;


    //показать все товары в корзине
    @GetMapping
    public String getProductsInCart(Model model){
        model.addAttribute("productsInCart", productInCartService.findAll());
        return "cart";
    }

    //удалить товар из корзины
    @GetMapping("/delete")
    public String deleteFromCartById(@RequestParam(name = "id") Long id){
        productInCartService.deleteById(id);
        return "redirect:/cart";
    }

    //отобразить ошибку/
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String errorMes(){

        return "ошибочка вышла";
    }
}
