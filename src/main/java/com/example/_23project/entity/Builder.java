package com.example._23project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private UUID builderId;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tell_Number")
    private int tellNumber;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

}
