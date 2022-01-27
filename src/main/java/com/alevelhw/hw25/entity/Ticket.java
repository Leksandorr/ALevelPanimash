package com.alevelhw.hw25.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;

    @NonNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "show_id")
    private Show show;

    @NonNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @NonNull
    @Column(name = "buying_date")
    private Date buyingDate;

    @NonNull
    @Column(name = "seat_number")
    private Integer seatNumber;
}
