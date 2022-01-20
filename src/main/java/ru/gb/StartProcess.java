package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.ProductConfiguration;

import java.util.Locale;
import java.util.Scanner;

public class StartProcess {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductConfiguration.class);
        ProductRepository rep = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);
        while (true){
            String inputData = input.nextLine().toUpperCase(Locale.ROOT);
            String[] inputArray = inputData.split(" ");
            try{
                switch(inputArray[0]){
                    case "GETPRODUCTS":
                        rep.showAllProducts();
                        break;
                    case "GET":
                        rep.showProductById(inputArray[1]);
                        break;
                    case "ADDTOCART":
                        cart.addProductToCart(rep.getListProducts(),inputArray[1]);
                        break;
                    case "SHOWCART":
                        cart.showCart();
                        break;
                    case "REMOVEFROMCART":
                        cart.removeProductFromCart(inputArray[1]);
                        break;
                    case "SHOWSUM":
                        cart.showSum();
                        break;
                    case "STOP":
                        return;
                }
             } catch (Exception e){System.out.println("Input does not match pattern");}
        }
    }
}
