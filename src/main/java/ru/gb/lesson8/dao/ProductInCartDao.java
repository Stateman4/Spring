package ru.gb.lesson8.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson8.entity.ProductInCart;

public interface ProductInCartDao extends JpaRepository<ProductInCart, Long> {
}
