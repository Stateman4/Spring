package ru.gb.lesson11.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.lesson11.dao.ProductDao;
import ru.gb.lesson11.dao.ProductInCartDao;
import ru.gb.lesson11.entity.Product;
import ru.gb.lesson11.entity.ProductInCart;

import java.util.List;

@Component
@Repository
@Transactional
public class ProductInCartRepository {

    @Autowired
    ProductInCartDao cartDao;

    @Autowired
    ProductDao productDao;

    @Transactional(readOnly = true)
    public List<ProductInCart> findAll(){
        return cartDao.findAll();
    }

    public ProductInCart save(Long id){
        Product product = productDao.getById(id);
        ProductInCart productInCart = new ProductInCart();
        Boolean isInside = false;
        int count = 0;
    //проверка, есть ли этот товар внутри корзины
        for(int i = 0; i < cartDao.findAll().size(); i++){
            ProductInCart cartProduct = cartDao.findAll().get(i);
            if(cartProduct.getIdProd() == id){
                cartDao.deleteById(cartProduct.getId()); //удалить для обновления в списке
                isInside = true;
                count = cartProduct.getCount() + 1;
            }
        }
        if(isInside == true) productInCart.setCount(count);
        else productInCart.setCount(1);
        productInCart.setIdProd(product.getId());
        productInCart.setTitle(product.getTitle());
        productInCart.setCost(product.getCost());
        return cartDao.save(productInCart);
    }

    public void deleteById(Long id) {
        cartDao.deleteById(id);
    }
}
