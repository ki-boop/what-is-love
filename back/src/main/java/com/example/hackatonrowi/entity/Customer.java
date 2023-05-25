package com.example.hackatonrowi.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
@ToString(callSuper = true)
public class Customer extends User {


    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Chat> chats;

    public Customer(String firstName, String lastName, String username, String email) {
        super(firstName, lastName, username, email);
    }
}
