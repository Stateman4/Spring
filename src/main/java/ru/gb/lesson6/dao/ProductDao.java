package ru.gb.lesson6.dao;

import ru.gb.lesson6.entity.Manufacturer;
import ru.gb.lesson6.entity.Product;

public interface ProductDao {
    Iterable<Product> findAll();
    Product findById(Long id);
    Manufacturer findManufacturerById(Long id);
    String findNameById(Long id);
    void insert(Product product);
    void update(Product product);
    void deleteById(Long id);
    Product save(Product product);
}
