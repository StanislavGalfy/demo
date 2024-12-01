package com.example.demo.model;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoRequestDTO {

    @NotNull
    private String name;
}
