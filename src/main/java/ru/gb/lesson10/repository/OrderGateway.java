package ru.gb.lesson10.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.lesson10.entity.Order;

@FeignClient(url = "localhost:8734/order", value = "orderGateway")
public interface OrderGateway {
    @GetMapping(value = "/create", produces = "application/json;charset=UTF-8")
    Order create();

    @DeleteMapping(value = "/delete/{orderId}")
    void delete(@PathVariable("orderId") Long id);
//@GetMapping(value = "/delete")
//void delete(Long id);
}
