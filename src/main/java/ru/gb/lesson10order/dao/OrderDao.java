package ru.gb.lesson10order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson10order.entity.Order;


public interface OrderDao extends JpaRepository<Order, Long> {

}
