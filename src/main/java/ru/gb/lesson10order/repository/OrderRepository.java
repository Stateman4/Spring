package ru.gb.lesson10order.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.lesson10order.dao.OrderDao;
import ru.gb.lesson10order.entity.Order;
import ru.gb.lesson10order.entity.ProductInCart;
import ru.gb.lesson10order.entity.enums.Delivery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Repository
@Transactional
public class OrderRepository {

    @Autowired
    private OrderDao orderDao;

    private ProductInCartRepository productInCartRepository;

    //показать все заказы
    @Transactional(readOnly = true)
    public List<Order> findAll(){
        return orderDao.findAll();
    }

    //удаление заказа
    public void deleteById(Long id) {
        orderDao.deleteById(id);
    }

    //создание заказа
    @Transactional
    public Order orderCreate(Order order){
     return  orderDao.save(order);
    }


}
