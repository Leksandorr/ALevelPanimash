package com.alevelhw.hw24.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "factories")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factory_id")
    long id;

    @Column(name = "factory_name")
    String name;
    String country;
}
