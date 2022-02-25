package ru.gb.lesson10.dto.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.gb.lesson10.dto.ProductDto;
import ru.gb.lesson10.dto.ProductDto.ProductDtoBuilder;
import ru.gb.lesson10.entity.Product;
import ru.gb.lesson10.entity.Product.ProductBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-24T09:53:44+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        product.id( productDto.getId() );
        product.title( productDto.getTitle() );
        product.cost( productDto.getCost() );
        product.date( productDto.getDate() );
        product.manufacturer_id( productDto.getManufacturer_id() );
        product.status( productDto.getStatus() );

        return product.build();
    }

    @Override
    public ProductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDtoBuilder productDto = ProductDto.builder();

        productDto.id( product.getId() );
        productDto.title( product.getTitle() );
        productDto.cost( product.getCost() );
        productDto.date( product.getDate() );
        productDto.manufacturer_id( product.getManufacturer_id() );
        productDto.status( product.getStatus() );

        return productDto.build();
    }
}
