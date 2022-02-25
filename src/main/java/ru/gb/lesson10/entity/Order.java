package ru.gb.lesson10.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gb.lesson10.entity.enums.Delivery;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Order {
    private long id;
    private String title;
    private BigDecimal cost;
    private LocalDate order_date;
    private Delivery delivery;

//    public Order(){
//        this.order_date = LocalDate.now();
//    }
}

