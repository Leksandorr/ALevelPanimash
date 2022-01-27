package com.alevelhw.hw25.repository;

import com.alevelhw.hw24.util.HibernateUtil;
import com.alevelhw.hw25.entity.Ticket;
import com.alevelhw.hw25.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserRepository {

    public List<Ticket> getAllTickets(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Ticket> ticketsList = session.createQuery("select t " +
                        "from Ticket t " +
                        "where t.user.id = :userId", Ticket.class)
                .setParameter("userId", user.getId())
                .list();

        transaction.commit();
        session.close();
        return ticketsList;
    }

    public List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<User> userList = session
                .createQuery("select u from User u", User.class)
                .list();

        transaction.commit();
        session.close();
        return userList;
    }

    public User getUser(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

    public void saveUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
}
