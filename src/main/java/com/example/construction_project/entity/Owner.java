package com.example.construction_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "owners")
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tell_Number")
    private String tellNumber;
}
