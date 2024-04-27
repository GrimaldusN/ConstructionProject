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
@Table(name = "work_process")
@NoArgsConstructor
public class WorkProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "action")
    private String action;

    @Column(name = "cost")
    private double cost;

    @Column(name = "builder")
    private String builder;
}
