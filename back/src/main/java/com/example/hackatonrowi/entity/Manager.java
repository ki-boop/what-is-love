package com.example.hackatonrowi.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Manager")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Manager extends User {

    @OneToMany(mappedBy = "manager",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Chat> chats;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Manager(String firstName, String lastName, String username, String email, String password) {
        super(firstName, lastName, username, email, password);
    }
}
