package com.alevelhw.hw25.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shows")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private Long id;

    @NonNull
    @Column(name = "seats_quantity")
    private Integer seatsQuantity;

    @NonNull
    @Column(name = "hall_number")
    private Integer hallNumber;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Ticket> ticketLists;
}
