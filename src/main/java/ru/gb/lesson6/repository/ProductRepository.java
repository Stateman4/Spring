package ru.gb.lesson6.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.lesson6.dao.ProductDao;
import ru.gb.lesson6.entity.Manufacturer;
import ru.gb.lesson6.entity.Product;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Component
@Repository
@Transactional
public class ProductRepository implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
       TypedQuery<Product> query  = entityManager.createNamedQuery("Product.findById", Product.class);
       query.setParameter("id", id);
       return query.getSingleResult();
    }

    @Override
    public Manufacturer findManufacturerById(Long id) {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public Product save(Product product) {
            entityManager.merge(product);
        return product;
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {
//    Product product = new Product();
//    product.setId(id);
//    product = entityManager.merge(product);
         Product savedProduct = findById(id);
        entityManager.remove(savedProduct);
    }
}
