package ru.gb.lesson10order.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.lesson10order.dao.ProductInCartDao;
import ru.gb.lesson10order.entity.ProductInCart;

import java.util.List;

@Component
@Repository
@Transactional
public class ProductInCartRepository {

    @Autowired
    ProductInCartDao cartDao;

    @Transactional(readOnly = true)
    public List<ProductInCart> findAll(){
        return cartDao.findAll();
    }

}
