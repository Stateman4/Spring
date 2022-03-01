package ru.gb.lesson11.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson11.entity.Product;
import ru.gb.lesson11.service.ProductInCartService;
import ru.gb.lesson11.service.ProductService;
//import ru.gb.lesson6.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
   private final ProductService productService;
   private final ProductInCartService productInCartService;


   @GetMapping
   public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {
      Product product;
      if (id != null) {
         product = productService.findById(id);
      } else {
         product = new Product();
      }
      model.addAttribute("product", product);
      return "product-form";
   }

   @PostMapping
   public String saveProduct(Product product) {
      productService.save(product);
      return "redirect:/product/all";
   }


   //удаление элементов
   @GetMapping(path = "/delete")
   public String deleteById(@RequestParam(name = "id") Long id){
      productService.deleteById(id);
      return "redirect:/product/all"; //куда отправить после использования метода
   }


//   //показать все элементы
   @GetMapping("/all")
   public String getAllProducts(Model model){
      model.addAttribute("products", productService.findAll());
      return "product-list";
   }

   //добавить товар в корзину
   @GetMapping(path = "/add")
   public String addProductToCart(@RequestParam(name = "id") Long id) {
      productInCartService.save(id);
      return "redirect:/product/all";
   }

   //показать все элементы в порядке убывания
   @GetMapping("/all/desc")
   public String getAllProductsDesc(Model model){
         model.addAttribute("products", productService.findAllSort(Sort.Direction.DESC));
         return "product-list";
   }
   //показать все элементы в порядке возрастания
   @GetMapping("/all/asc")
   public String getAllProductsAsc(Model model){
    model.addAttribute("products", productService.findAllSort(Sort.Direction.ASC));
      return "product-list";
   }


   //отобразить ошибку/
   @ExceptionHandler(RuntimeException.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   @ResponseBody
   public String errorMes(){

      return "ошибочка вышла";
   }
}
