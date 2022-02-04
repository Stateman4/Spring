package ru.gb.dao;

import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

public interface ProductDao {
    Iterable<Product> findAll();
    Product findById(Long id);
    Manufacturer findManufacturerById(Long id);
    String findNameById(Long id);
    void insert(Product product);
    void update(Product product);
    void deleteById(Long id);
}
