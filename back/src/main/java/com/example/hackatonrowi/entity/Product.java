package com.example.hackatonrowi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name="product_generator", sequenceName = "product_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;
}
