package ru.gb.lesson12.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson12.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
