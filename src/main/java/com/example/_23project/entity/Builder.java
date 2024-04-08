package com.example._23project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "builder")
@NoArgsConstructor
public class Builder extends Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tell_Number")
    private int tellNumber;
}
