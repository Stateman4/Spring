package ru.gb.lesson9.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson9.entity.ProductInCart;

public interface ProductInCartDao extends JpaRepository<ProductInCart, Long> {
}
