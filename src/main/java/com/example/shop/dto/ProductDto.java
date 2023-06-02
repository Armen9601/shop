package com.example.shop.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class ProductDto {

    private Long id;
    private String number;
    private String manufacturer;
    private Double price;
    private Integer count;

}
