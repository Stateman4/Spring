package ru.gb.dao;

import lombok.extern.slf4j.Slf4j;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


public class OldJdbcProductDao implements ProductDao{

    private Connection getConnection() throws SQLException{
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/products?currentSchema=public&user=postgres&password=89151723775");
    }

    private void closeConnection(Connection connection){
        if(connection==null) return;
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Product> findAll() {
        Connection connection = null;
        Set<Product> result = new HashSet<>();
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = statement.executeQuery(); //вывод таблицы положился в резултСет
            while (resultSet.next()){
                final Product product = Product.builder()
                        .id(resultSet.getLong("id"))
                        .title(resultSet.getString("title"))
                        .cost(resultSet.getBigDecimal("cost"))
                        .date(resultSet.getDate("manufacture_date").toLocalDate())
                        .manufacturer_id(resultSet.getLong("manufacturer_id"))
                        .build();
                    result.add(product);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Manufacturer findManufacturerById(Long id) {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
