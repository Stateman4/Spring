package ru.gb.lesson10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson10.entity.Order;
import ru.gb.lesson10.repository.OrderGateway;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderGateway orderGateway;

    // создать заказ
    @GetMapping("/createOrder")
    public Order create(){
        return orderGateway.create();
    }

//    @DeleteMapping("/deleteOrder/{orderId}")
//    public void delete(@PathVariable("productId") Long id){
//        orderGateway.delete(id);
//    }

    @DeleteMapping("/delete/{orderId}")
    public void delete(@PathVariable("orderId") Long id){
        orderGateway.delete(id);
    }
}
