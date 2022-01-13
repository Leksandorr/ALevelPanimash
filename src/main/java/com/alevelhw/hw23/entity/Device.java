package com.alevelhw.hw23.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@ToString
public class Device {
    long id;
    String type;
    String model;
    BigDecimal price;
    Date date;
    String description;
    boolean isAvailable;
    long factoryId;
}
