package com.example._23project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "material_quantity")
@NoArgsConstructor
public class MaterialQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;
}
