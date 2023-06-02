package com.example.shop.dto;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HardDiskDto extends ProductDto{

    private Long capacity;
}
