package ru.gb.lesson10.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson10.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
