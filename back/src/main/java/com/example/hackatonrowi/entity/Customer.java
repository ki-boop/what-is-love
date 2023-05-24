package com.example.hackatonrowi.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Customers")
@Getter
@Setter
@SuperBuilder
//@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Customer extends User {
    public Customer(String firstName, String lastName, String username, String email, String password) {
        super(firstName, lastName, username, email, password);
    }
}
