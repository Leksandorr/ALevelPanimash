package com.alevelhw.hw25.repository;

import com.alevelhw.hw24.util.HibernateUtil;
import com.alevelhw.hw25.entity.Show;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ShowRepository {

    public List<Show> getAllShows() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Show> showList = session
                .createQuery("select s from Show s", Show.class)
                .list();

        transaction.commit();
        session.close();
        return showList;
    }

    public void saveShow(Show show) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(show);
        transaction.commit();
        session.close();
    }
}
