package com.alevelhw.hw24.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "devices")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    long id;

    @Column(name = "device_type")
    String type;
    String model;
    BigDecimal price;

    @Column(name = "creation_date")
    Date date;
    String description;

    @Column(name = "is_available")
    boolean isAvailable;

    @ManyToOne()
    @JoinColumn(name = "factory_id")
    Factory factory;
}
