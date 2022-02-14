package ru.gb.lesson8.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson8.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
