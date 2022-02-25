package ru.gb.lesson10order.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gb.lesson10order.entity.enums.Delivery;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name="orders", schema="public")
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "order_date")
    private LocalDate order_date;
    @Enumerated(EnumType.STRING)
    @Column(name = "delivery")
    private Delivery delivery;

//    public Order(){
//        this.order_date = LocalDate.now();
//    }
}

