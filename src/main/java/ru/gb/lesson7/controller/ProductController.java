package ru.gb.lesson7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson7.dao.ProductDao;
import ru.gb.lesson7.entity.Product;
import ru.gb.lesson7.service.ProductService;
//import ru.gb.lesson6.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
   private final ProductService productService;

   //Форма для создания нового товара GET /products/create
   @GetMapping("/create")
   public String showCreateForm(Model model){
      Product product = new Product();
      model.addAttribute(product);
      return "create-product";
   }

   //Форма для создания нового товара POST
   @RequestMapping(value = "/create", method = RequestMethod.POST)
   public String processForm(Product product){
      productService.save(product);
      return "redirect:/product/all"; //перекинуть на ссылку всех товаров
   }

   //показать один элемент
   @GetMapping(path = "/{id}")
   public String getProductById(Model model, @PathVariable Long id){
         Product product;
         product = productService.findById(id);
         model.addAttribute("product", product);
         return "product";
   }

// изменение элементов
   @GetMapping(path = "/edit")
   public String editById(Model model, @RequestParam Long id){
      Product product = productService.findById(id);
      model.addAttribute("product",product);
      return "create-product";
   }
   //удаление элементов
   @GetMapping(path = "/delete")
   public String deleteById(@RequestParam Long id){
      productService.deleteById(id);
      return "redirect:/product/all"; //куда отправить после использования метода
   }

   //показать все элементы в порядке убывания
   @GetMapping("/all")
   public String getAllProducts(Model model){
      model.addAttribute("products", productService.findAll());
      return "product-list";
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


   //отобразить ошибку/ функционал добавил, но не стал использовать
   @ExceptionHandler(RuntimeException.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   @ResponseBody
   public String errorMes(){

      return "ошибочка вышла";
   }
}
