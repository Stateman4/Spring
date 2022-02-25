package ru.gb.lesson10order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson10order.entity.ProductInCart;

public interface ProductInCartDao extends JpaRepository<ProductInCart, Long> {
}
