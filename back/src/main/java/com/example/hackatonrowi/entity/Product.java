package com.example.hackatonrowi.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Product")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;
//    @ManyToMany()
//    private List<Manager> managers;


    public Product(String name) {
        this.name = name;
    }
}
