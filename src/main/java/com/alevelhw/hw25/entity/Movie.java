package com.alevelhw.hw25.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @NonNull
    @Column(name = "movie_title")
    private String movieTitle;

    @NonNull
    @Column(name = "producing_date")
    private Date producingDate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Show> showList;
}
