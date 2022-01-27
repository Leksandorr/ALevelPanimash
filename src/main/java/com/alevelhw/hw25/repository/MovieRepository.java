package com.alevelhw.hw25.repository;

import com.alevelhw.hw24.util.HibernateUtil;
import com.alevelhw.hw25.entity.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieRepository {

    public Movie getMovieByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Movie movie = session.createQuery("select m " +
                        "from Movie m " +
                        "where m.movieTitle = :movieTitle", Movie.class)
                .setParameter("movieTitle", title)
                .uniqueResult();

        transaction.commit();
        session.close();
        return movie;
    }

    public void saveMovie(Movie movie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(movie);
        transaction.commit();
        session.close();
    }

    public Movie getMovie(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Movie movie = session.get(Movie.class, id);
        transaction.commit();
        session.close();
        return movie;
    }
}
