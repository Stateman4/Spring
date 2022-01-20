package ru.gb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.gb")
@PropertySource("classpath:text.properties")
public class ProductConfiguration {
}
