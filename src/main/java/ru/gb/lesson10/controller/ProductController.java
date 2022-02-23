package ru.gb.lesson10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson10.service.ProductInCartService;
import ru.gb.lesson10.service.ProductService;
import ru.gb.lesson10.dto.ProductDto;
import ru.gb.lesson10.entity.Product;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
   private final ProductService productService;
   private final ProductInCartService productInCartService;


   @GetMapping()
   public List<Product> getProductList(){
      return productService.findAll();
   }

   //показать все элементы в порядке убывания стоимости
   @GetMapping("/desc")
   public List<Product> getProductListDesc(){
         return productService.findAllSort(Sort.Direction.DESC);
   }

   //показать все элементы в порядке возрастания стоимости
   @GetMapping("/asc")
   public List<Product> getProductListAsc(){
      return productService.findAllSort(Sort.Direction.ASC);
   }

   @GetMapping("/{productId}")
   public ResponseEntity<? extends Product> getProduct(@PathVariable("productId") Long id){
      if(id != null){
        Product product = productService.findById(id);
        if(product != null){
           return new ResponseEntity<>(product, HttpStatus.OK);
        }
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @PostMapping
   public ResponseEntity<?> handlePost(@Validated @RequestBody ProductDto productDto){
      ProductDto savedProduct = productService.save(productDto);
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.setLocation(URI.create("api/v1/product/" + savedProduct.getId()));
      return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
   }

   @PutMapping("/{productId}")
   public ResponseEntity<?> handlUpdate(@PathVariable("productId") Long id,@Validated @RequestBody ProductDto productDto){
      productDto.setId(id);
      productService.save(productDto);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

   @DeleteMapping("/{productId}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void deleteById(@PathVariable("productId") Long id){
      productService.deleteById(id);
   }

   //добавить товар в корзину
   @GetMapping("/add/{productId}")
   @ResponseStatus(HttpStatus.OK)
   public void addProductToCart(@PathVariable("productId") Long id) {
      productInCartService.save(id);
   }
}
