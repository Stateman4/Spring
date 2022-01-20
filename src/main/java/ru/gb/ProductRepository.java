package ru.gb;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class ProductRepository implements BeanPostProcessor {

    //список товаров
    public ArrayList<Product> arrayProducts;

    //текст из text.properties
    public String textOfGetProducts;
    private Environment environment;

    //конструктор класса
    @Autowired
    public ProductRepository(Environment environment){
        this.environment = environment;
        this.arrayProducts = newList();
    }

    //метод инициализирующий текст
    @PostConstruct
    public void init(){
        textOfGetProducts = environment.getProperty("textOfGetProducts");
    }

    //метод выводящий текст по работе со списком товаров
    public void showText(){
        System.out.println(textOfGetProducts);
    }

    //Метод, вызываемый при инициализации
    @Override
    public Object postProcessBeforeInitialization(Object bean, String Repos) throws BeansException {
        //за 1 запуск Бина делает сразу 5 товаров(в конструкторе)
        showText();
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, Repos);
    }

    //метод для заполнения списка товаров
    public ArrayList<Product> newList(){
        ArrayList<Product> productArray = new ArrayList<Product>();
        for(int i = 0; i < 5; i++){
            productArray.add(new Product(String.valueOf(i),"product"+i,String.format("%.0f", Math.random()*1000)));
        }
        return productArray;
    }

//Метод по получениютовара по id
    public Product getProduct(String id){
        for(Product product:arrayProducts){
            if(product.id.equals(id)) return product;
        }
        return null;
    }

    //метод по получению списка товаров
    public ArrayList<Product> getListProducts(){
        return arrayProducts;
    }

    //метод вывода всех товаров в консоль
    public void showAllProducts(){
        for(Product product:arrayProducts){
            System.out.println("id: "+product.id+" title: "+product.title+" cost: "+product.cost);
        }
    }

    //метод вывода товара в консоль по id
    public void showProductById(String id){
        for(Product product:arrayProducts){
            if(product.id.equals(id)) System.out.println("id: "+product.id+" title: "+product.title+" cost: "+product.cost);
        }
    }
}
