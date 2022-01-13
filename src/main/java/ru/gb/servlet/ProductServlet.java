package ru.gb.servlet;

import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", getProducts());
        getServletContext().getRequestDispatcher("/products.jsp").forward(req,resp); // передаю дополненный реквест и респонс в product.jsp
    }

    //создаю список выводимых товаров. Передавать в jsp буду объект класса ArrayList
    private ArrayList<Product> getProducts(){
        ArrayList<Product> list = new ArrayList<Product>();
        for(int i = 0; i < 10; i++){
            list.add(new Product(String.valueOf(i),"product"+i, String.format("%.1f", Math.random()*1000)));
        }
        return list;
    }
}
