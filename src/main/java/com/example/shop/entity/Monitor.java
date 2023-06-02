package com.example.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "monitors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Monitor extends Product{

    private Integer diagonal;

}
