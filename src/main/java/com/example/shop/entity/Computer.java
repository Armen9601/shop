package com.example.shop.entity;

import com.example.shop.entity.enums.ComputerType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "computers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Computer extends Product{

    @Enumerated(value = EnumType.STRING)
    private ComputerType type;

}
