package com.alevelhw.hw25;

import com.alevelhw.hw25.entity.Movie;
import com.alevelhw.hw25.entity.Show;
import com.alevelhw.hw25.entity.Ticket;
import com.alevelhw.hw25.entity.User;
import com.alevelhw.hw25.repository.MovieRepository;
import com.alevelhw.hw25.repository.ShowRepository;
import com.alevelhw.hw25.repository.TicketRepository;
import com.alevelhw.hw25.repository.UserRepository;

import java.sql.Date;

public class Main {
    private static final MovieRepository movieRepository = new MovieRepository();
    private static final ShowRepository showRepository = new ShowRepository();
    private static final UserRepository userRepository = new UserRepository();
    private static final TicketRepository ticketRepository = new TicketRepository();

    public static void main(String[] args) {
        addUsersToDatabase();
        addMoviesToDatabase();
        addShowsToDatabase();
        addTicketsToDatabase();

        System.out.println();
        System.out.println("+++++++++++++++++++ Все сеансы +++++++++++++++++++");
        showRepository.getAllShows()
                .forEach(System.out::println);
        System.out.println();
        System.out.println("+++++++++++++++++++ Все пользователи +++++++++++++++++++");
        userRepository.getAllUsers()
                .forEach(System.out::println);
        System.out.println();
        System.out.println("+++++++++++++++++++ Фильм по названию +++++++++++++++++++");
        System.out.println(movieRepository.getMovieByTitle("UberHit"));
        System.out.println();
        System.out.println("+++++++++++++++++++ Все билеты у конкретного юзера +++++++++++++++++++");
        userRepository.getAllTickets(
                userRepository.getUser(8L))
                .forEach(System.out::println);
        System.out.println();
        System.out.println("+++++++++++++++++++ Удаляем билет +++++++++++++++++++");
        ticketRepository.deleteTicket(ticketRepository.getTicket(1L));
        System.out.println(ticketRepository.getTicket(1L));
    }

    public static void addUsersToDatabase() {
        userRepository.saveUser(new User("Ron", Date.valueOf("1995-07-11")));
        userRepository.saveUser(new User("Den", Date.valueOf("1995-01-14")));
        userRepository.saveUser(new User("Bob", Date.valueOf("1995-03-04")));
        userRepository.saveUser(new User("Lea", Date.valueOf("2002-10-21")));
        userRepository.saveUser(new User("Din", Date.valueOf("1995-01-19")));
        userRepository.saveUser(new User("Neo", Date.valueOf("1990-04-09")));
        userRepository.saveUser(new User("Ann", Date.valueOf("1995-12-15")));
        userRepository.saveUser(new User("Kuk", Date.valueOf("1977-06-05")));
        userRepository.saveUser(new User("Don", Date.valueOf("1993-05-30")));
        userRepository.saveUser(new User("Ben", Date.valueOf("1998-02-27")));
    }

    public static void addMoviesToDatabase() {
        movieRepository.saveMovie(new Movie("SuperHit", Date.valueOf("2022-01-01")));
        movieRepository.saveMovie(new Movie("DuperHit", Date.valueOf("2022-01-02")));
        movieRepository.saveMovie(new Movie("UberHit", Date.valueOf("2022-01-03")));
        movieRepository.saveMovie(new Movie("MegaHit", Date.valueOf("2022-01-04")));
    }

    public static void addShowsToDatabase() {
        showRepository.saveShow(new Show(60, 1, movieRepository.getMovie(1L)));
        showRepository.saveShow(new Show(80, 2, movieRepository.getMovie(2L)));
        showRepository.saveShow(new Show(100, 3, movieRepository.getMovie(3L)));
        showRepository.saveShow(new Show(60, 1, movieRepository.getMovie(4L)));
    }

    public static void addTicketsToDatabase() {
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(3),
                userRepository.getAllUsers().get(1), Date.valueOf("2022-01-20"), 45));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(3),
                userRepository.getAllUsers().get(2), Date.valueOf("2022-01-20"), 46));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(3),
                userRepository.getAllUsers().get(3), Date.valueOf("2022-01-20"), 44));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(3),
                userRepository.getAllUsers().get(4), Date.valueOf("2022-01-20"), 43));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(2),
                userRepository.getAllUsers().get(5), Date.valueOf("2022-01-20"), 45));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(1),
                userRepository.getAllUsers().get(6), Date.valueOf("2022-01-20"), 45));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(1),
                userRepository.getAllUsers().get(6), Date.valueOf("2022-01-20"), 46));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(1),
                userRepository.getAllUsers().get(7), Date.valueOf("2022-01-20"), 47));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(0),
                userRepository.getAllUsers().get(7), Date.valueOf("2022-01-20"), 46));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(0),
                userRepository.getAllUsers().get(7), Date.valueOf("2022-01-21"), 45));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(0),
                userRepository.getAllUsers().get(8), Date.valueOf("2022-01-20"), 44));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(0),
                userRepository.getAllUsers().get(8), Date.valueOf("2022-01-20"), 40));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(3),
                userRepository.getAllUsers().get(8), Date.valueOf("2022-01-21"), 48));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(3),
                userRepository.getAllUsers().get(8), Date.valueOf("2022-01-21"), 34));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(2),
                userRepository.getAllUsers().get(9), Date.valueOf("2022-01-21"), 37));
        ticketRepository.saveTicket(new Ticket(showRepository.getAllShows().get(3),
                userRepository.getAllUsers().get(0), Date.valueOf("2022-01-21"), 55));
    }
}