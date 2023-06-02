package com.example.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "hard_disks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HardDisk extends Product{

    private Long capacity;
}
