package ru.gb.lesson11.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson11.entity.ProductInCart;

public interface ProductInCartDao extends JpaRepository<ProductInCart, Long> {
}
