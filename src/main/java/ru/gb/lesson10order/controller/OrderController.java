package ru.gb.lesson10order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson10order.entity.Order;
import ru.gb.lesson10order.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    //показать все заказы
    @GetMapping()
    public List<Order> getCartList(){
        return orderService.findAll();
    }

    //удалить заказ
    @DeleteMapping("/delete/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("orderId") Long id){
        orderService.deleteById(id);
    }

    @GetMapping("/create")
    public Order orderCreate(){
        return orderService.orderCreate();
    }
}
