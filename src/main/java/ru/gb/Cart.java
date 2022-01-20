package ru.gb;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Cart implements BeanPostProcessor {
    //список товаров в корзине
    public ArrayList<Product> cartArray = new ArrayList<Product>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      if(cartArray.size() == 0) System.out.println("Cart is empty");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

        //метод добавления товара по id
    public void addProductToCart(ArrayList<Product> arrayProducts, String id){
        for(Product product: arrayProducts){
            if(product.id.equals(id)){
                System.out.println("Product: "+product.title+" was added to cart");
                cartArray.add(product);
            }
        }
    }

    //метод удаления товара по id
    public void removeProductFromCart(String id){
    for(int i = 0; i < cartArray.size(); i++){
        if(cartArray.get(i).id.equals(id)){
            System.out.println("Product: " + cartArray.get(i).title + " was removed from cart");
            cartArray.remove(i);
            i--;
        }
    }
    }

    //метод вывода содержимого корзины в консоль
    public void showCart(){
        for(Product product: cartArray){
            System.out.println("id: "+product.id+" title: "+product.title+" cost: "+product.cost);
        }
        if (cartArray.size() == 0)System.out.println("Cart is empty");
    }

    //метод выводящий в консоль сумму стоимости всех товаров в корзине
    public void showSum(){
        double sum = 0;
        for(Product product:cartArray){
          sum = sum + Double.parseDouble(product.cost);;
        }
        System.out.println(sum);
    }
}
