package com.example.shop.dto;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NoteBookDto extends ProductDto{

    private Integer inch;

}
