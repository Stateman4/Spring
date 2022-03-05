package ru.gb.lesson12.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.lesson12.dao.ProductDao;
import ru.gb.lesson12.entity.Product;


import java.util.List;
import java.util.Optional;


@Component
@Repository
@Transactional
public class ProductRepository {

    @Autowired
    private ProductDao dao;

    @Transactional(readOnly = true)
    public List<Product> findAll(){
        return dao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> findAllSort(Sort.Direction direction){
        return dao.findAll(Sort.by(direction,"cost"));
    }
    @Transactional(readOnly = true)
    public Product findById(Long id){
        return dao.findById(id).get();
    }

    public Product save(Product product){
        if(String.valueOf(product.getId()) != null){
            Optional<Product> productFromDbOptional = dao.findById(product.getId());
            if(productFromDbOptional.isPresent()){
                Product productFromDb = productFromDbOptional.get();
                productFromDb.setTitle(product.getTitle());
                productFromDb.setDate(product.getDate());
                productFromDb.setCost(product.getCost());
                productFromDb.setStatus(product.getStatus());
                return dao.save(productFromDb);
            }
        }
        dao.save(product);
        return product;
    }

    public void deleteById(Long id) {
        dao.deleteById(id);
    }

}
