package ru.gb.lesson9.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson9.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
