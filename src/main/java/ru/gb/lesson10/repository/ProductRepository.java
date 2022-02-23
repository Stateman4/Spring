package ru.gb.lesson10.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.lesson10.dao.ProductDao;
import ru.gb.lesson10.dto.ProductDto;
import ru.gb.lesson10.entity.Product;

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

    public ProductDto save(ProductDto productDto){
        Product savingProduct;
        Optional<Product> productFromOptional = Optional.empty();
        if(String.valueOf(productDto.getId()) != null) {
            productFromOptional = dao.findById(productDto.getId());
        }
        savingProduct = productFromOptional.orElseGet(Product::new);
        savingProduct.setTitle(productDto.getTitle());
        savingProduct.setDate(productDto.getDate());
        savingProduct.setCost(productDto.getCost());
        savingProduct.setStatus(productDto.getStatus());
        savingProduct = dao.save(savingProduct);
        productDto.setId(savingProduct.getId());
        return productDto;
    }

    public void deleteById(Long id) {
        dao.deleteById(id);
    }

}
