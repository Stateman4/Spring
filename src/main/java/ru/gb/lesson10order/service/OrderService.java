package ru.gb.lesson10order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.lesson10order.dao.OrderDao;
import ru.gb.lesson10order.dao.ProductInCartDao;
import ru.gb.lesson10order.entity.Order;
import ru.gb.lesson10order.entity.ProductInCart;
import ru.gb.lesson10order.entity.enums.Delivery;
import ru.gb.lesson10order.repository.OrderRepository;
import ru.gb.lesson10order.repository.ProductInCartRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDao orderDao;
    private final ProductInCartDao productInCartDao;


    //метод поиска всех заказов
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    //метод удаления заказа
    public void deleteById(Long id){
        orderRepository.deleteById(id);
    }

    //метод добавления заказа
    public Order orderCreate(){
        Order order = new Order();
        String order_title = "";
        Double order_cost = 0.0;
        ArrayList<ProductInCart> cartProducts = new ArrayList<>(productInCartDao.findAll());
        for(int i = 0; i < cartProducts.size(); i++){
            order_title += cartProducts.get(i).getTitle() + "; ";
            order_cost += cartProducts.get(i).getCost().doubleValue() * cartProducts.get(i).getCount();
        }
        order.setTitle(order_title);
        order.setCost(BigDecimal.valueOf(order_cost));
        order.setOrder_date(LocalDate.now());
        order.setDelivery(Delivery.DELIVERY);
        return orderRepository.orderCreate(order);
    }

}
