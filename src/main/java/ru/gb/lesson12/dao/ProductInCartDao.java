package ru.gb.lesson12.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson12.entity.ProductInCart;

public interface ProductInCartDao extends JpaRepository<ProductInCart, Long> {
}
