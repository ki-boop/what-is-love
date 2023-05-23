package com.example.hackatonrowi.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Manager")
@Getter
@Setter
@Builder
@ToString
public class Manager {
    @Id
    private UUID id;

//    @Column(name = "product")
//    @ManyToMany()
//    private Product product;
}
