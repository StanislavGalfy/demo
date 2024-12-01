package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "demo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
