package ru.gb.lesson10order.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Delivery {
    DELIVERY("Доставка"), PICKUP("Самовывоз");

    private final String title;
}
