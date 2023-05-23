package com.example.hackatonrowi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Product")
@Getter
@Setter
@Builder
@ToString
public class Product {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;
//    @ManyToMany()
//    private List<Manager> managers;
}
