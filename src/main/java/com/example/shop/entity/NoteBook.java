package com.example.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "notebooks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NoteBook extends Product {

    private Integer inch;

}
