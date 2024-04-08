package com.example._23project.entity;

import jakarta.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "authorities")
@NoArgsConstructor
public class Autauthorities {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "authority_Name")
    private String authorityName;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;

}
