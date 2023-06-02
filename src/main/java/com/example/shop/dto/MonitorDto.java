package com.example.shop.dto;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MonitorDto extends ProductDto{

    private Integer diagonal;

}
