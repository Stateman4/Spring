package ru.gb.lesson10.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.lesson10.dao.ProductDao;
import ru.gb.lesson10.dto.ProductDto;
import ru.gb.lesson10.dto.mapper.ProductMapper;
import ru.gb.lesson10.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
@Repository
@Transactional
public class ProductRepository {

    @Autowired
    private ProductDao dao;

    @Autowired
    private ProductMapper productMapper;

    @Transactional(readOnly = true)
    public List<ProductDto> findAll(){
        return dao.findAll().stream().map(productMapper::toProductDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Product> findAllSort(Sort.Direction direction){
        return dao.findAll(Sort.by(direction,"cost"));
    }

    @Transactional(readOnly = true)
    public ProductDto findById(Long id){
        return productMapper.toProductDto(dao.findById(id).get());
    }

    @Transactional
    public ProductDto save(ProductDto productDto){
       Product product = productMapper.toProduct(productDto);
       if(String.valueOf(product.getId()) != null){
           dao.findById(productDto.getId()).ifPresent(
                   p -> product.setVersion(p.getVersion())
           );
       }
       return productMapper.toProductDto(dao.save(product));
    }

    public void deleteById(Long id) {
        dao.deleteById(id);
    }

}
