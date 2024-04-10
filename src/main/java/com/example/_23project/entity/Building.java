package com.example._23project.entity;

import com.example._23project.entity.Adress;
import com.example._23project.entity.Builder;
import com.example._23project.entity.Material;
import com.example._23project.entity.Owner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "building")
@NoArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "cost")
    private double cost;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "address_id")
    private Adress address;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @JsonIgnore
    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private Set<MaterialQuantity> materials;

    @JsonIgnore
    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<Builder> builders;
}
