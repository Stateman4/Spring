package ru.gb.lesson9.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="cart", schema="public")
public class ProductInCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "idprod")
    private long idProd;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "count")
    private Integer count;
}
