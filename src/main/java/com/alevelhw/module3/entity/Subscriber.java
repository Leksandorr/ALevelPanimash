package com.alevelhw.module3.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subscribers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriber_id")
    protected Long id;

    @NonNull
    @Column(name = "phone_number")
    protected Long phoneNumber;

    @NonNull
    @Column(name = "first_name")
    protected String firstName;

    @NonNull
    @Column(name = "last_name")
    protected String lastName;

    @NonNull
    protected String patronymic;

    @NonNull
    protected String city;

    @NonNull
    @JoinColumn(name = "current_tariff_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    protected Tariff currentTariff;

    @NonNull
    @ManyToMany
    @JoinTable(name = "subscribers_equipments",
            joinColumns = @JoinColumn(name = "subscriber_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    @ToString.Exclude
    protected List<Equipment> equipments;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    @ToString.Exclude
    protected List<Activity> activities;

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", city='" + city + '\'' +
                ", currentTariff=" + currentTariff.id +
                '}';
    }
}
