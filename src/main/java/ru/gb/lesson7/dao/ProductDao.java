package ru.gb.lesson7.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson7.entity.Manufacturer;
import ru.gb.lesson7.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
