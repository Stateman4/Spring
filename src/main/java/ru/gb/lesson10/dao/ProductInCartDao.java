package ru.gb.lesson10.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson10.entity.ProductInCart;

public interface ProductInCartDao extends JpaRepository<ProductInCart, Long> {
}
