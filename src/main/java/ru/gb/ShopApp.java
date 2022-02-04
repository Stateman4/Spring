package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import ru.gb.config.DbConfig;
import ru.gb.config.HibernateConfig;
import ru.gb.dao.OldJdbcProductDao;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Product;

public class ShopApp {
    public static void main(String[] args) {

        //первый вариант вывода всех товаров JDBC (+)
//        OldJdbcProductDao oldJdbcProductDao = new OldJdbcProductDao();
//            for(Product product: oldJdbcProductDao.findAll()){
//                System.out.println(product);
//            }

        //второй вариант. работа со Spring JDBC (+)
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        for(Product product: productDao.findAll()){
//            System.out.println(product);
//        }

        //третий вариант абстракции с JDBC Template + четвертый вариант JDBC NameTemplate
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        System.out.println(productDao.findNameById(Long.valueOf(30)));

        //четвертый вариант вывод всех продуктов JDBC NameTemplate
//       for(Product product: productDao.findAll()){
//          System.out.println(product);
//    }
           //вывод производителя по id
  //      System.out.println(productDao.findManufacturerById(Long.valueOf(84)));

        //пятый вариант абстракции Hibernate
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
//        for(Product product: productDao.findAll()){
//            System.out.println(product);
//        }
//        //поиск товара по id и Названия по id
        System.out.println(productDao.findById(Long.valueOf(47)));
        System.out.println(productDao.findNameById(Long.valueOf(47)));
        }
    }

