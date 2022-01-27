package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.entiry.Product;
import ru.gb.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
   private final ProductService productService;

   //Форма для создания нового товара GET /products/create
   @RequestMapping(value = "/create", method = RequestMethod.GET)
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
   @RequestMapping(path = "/{id}", method = RequestMethod.GET) //localhost:8080/spring/products/{id}
   public String getMessageById(Model model, @PathVariable Integer id){
      Product product;
      product = productService.findById(id);
      model.addAttribute("product", product);
      return "product";
   }

   //показать все элементы
   @RequestMapping("/all")
   public String getAllProducts(Model model){
      model.addAttribute("products",productService.findAll());
      return "product-list";
   }
}
