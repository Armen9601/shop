package com.example.shop.dto;

import com.example.shop.entity.enums.ComputerType;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComputerDto extends ProductDto{

    private ComputerType type;

}
