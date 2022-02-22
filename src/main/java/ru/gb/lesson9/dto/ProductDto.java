package ru.gb.lesson9.dto;

import lombok.*;
import ru.gb.lesson9.entity.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private long id;

    @NotBlank(message = "title is required") //сообщение покажется в случае ошибки
    private String title;

    @NotNull //ненулевое значение
    @DecimalMin(value = "0.0", inclusive = false) // больше нуля, не включая ноль
    @Digits(integer = 5, fraction = 2) //5 знаков до запятой и 2 после запятой
    private BigDecimal cost;

    @PastOrPresent //не может быть изготовлен раньше, чем создание
    private LocalDate date;

    @NotNull
    private Long manufacturer_id;

    @NotNull
    private Status status;
}
