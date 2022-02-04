package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

//@Component
@RequiredArgsConstructor
public class NamedParametrJdbcTemplateProduuctDao implements ProductDao{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM product";
        return namedParameterJdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public Product findById(Long id) {
        return null;
       }

    @Override
    public Manufacturer findManufacturerById(Long id) {
        String sql = "SELECT name, p.id as product_id, title, cost,\n" +
                "manufacture_date, manufacturer_id\n" +
                "FROM manufacturer m JOIN product p on m.id = p.manufacturer_id \n" +
                "WHERE m.id = manufacturer_id;";
        HashMap<String,Object> namedParemeters = new HashMap<>();
        namedParemeters.put("manufacturerId",id);
        return namedParameterJdbcTemplate.query(sql, namedParemeters, new ManufacturerWithProductsExtractor());

    }

    @Override
    public String findNameById(Long id) {
        String sql = "SELECT title FROM product where id = :productId";
        HashMap<String,Object> namedParemeters = new HashMap<>();
        namedParemeters.put("productId",id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParemeters, String.class);
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

    private static class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Product.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("title"))
                    .cost(rs.getBigDecimal("cost"))
                    .date(rs.getDate("manufacture_date").toLocalDate())
                    .manufacturer_id(rs.getLong("manufacturer_id"))
                    .build();
        }
    }

    private static class ManufacturerWithProductsExtractor implements ResultSetExtractor<Manufacturer>{

        @Override
        public Manufacturer extractData(ResultSet rs) throws SQLException, DataAccessException {
            Manufacturer manufacturer = null;
            while (rs.next()) {
                long id = rs.getLong("manufacturer_id");
                if(manufacturer == null){
                    manufacturer = Manufacturer.builder()
                            .id(id)
                            .name(rs.getString("name"))
                            .build();
                }
                long productId = rs.getLong("product_id");
                final Product product = Product.builder()
                        .id(rs.getLong("product_id"))
                        .title(rs.getString("title"))
                        .cost(rs.getBigDecimal("cost"))
                        .date(rs.getDate("manufacture_date").toLocalDate())
                        .manufacturer_id(rs.getLong("manufacturer_id"))
                        .build();
                manufacturer.addProduct(product);
            }
            return manufacturer;
        }
    }
}
