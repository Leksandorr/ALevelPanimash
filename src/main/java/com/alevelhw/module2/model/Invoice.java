package com.alevelhw.module2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@ToString
@Getter
@Setter
public class Invoice {
    private Customer customer;
    private String type;
    private Set <Telephone> telephonesSet = new LinkedHashSet<>();
    private Set <Television> televisionsSet = new LinkedHashSet<>();
}