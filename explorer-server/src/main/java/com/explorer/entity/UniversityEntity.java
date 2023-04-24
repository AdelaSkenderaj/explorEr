package com.explorer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "UNIVERSITY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniversityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;
}
