package com.example.demo.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoResponseDTO {

    private Long id;

    private String name;
}
