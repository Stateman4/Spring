package ru.gb.lesson10.dto.mapper;

import org.mapstruct.Mapper;
import ru.gb.lesson10.dto.ProductDto;
import ru.gb.lesson10.entity.Product;

@Mapper
public interface ProductMapper {
    Product toProduct(ProductDto productDto);
    ProductDto toProductDto(Product product);
}
