package com.example.hackatonrowi.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "Roles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_generator")
    @SequenceGenerator(name="roles_generator", sequenceName = "roles_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoleName name;
}
