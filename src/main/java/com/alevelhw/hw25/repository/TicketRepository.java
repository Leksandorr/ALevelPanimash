package com.alevelhw.hw25.repository;

import com.alevelhw.hw24.util.HibernateUtil;
import com.alevelhw.hw25.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TicketRepository {

    public void deleteTicket(Ticket ticket) {
        Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(ticket);
        transaction.commit();
        session.close();
    }

    public void saveTicket(Ticket ticket) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ticket);
        transaction.commit();
        session.close();
    }

    public Ticket getTicket(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        transaction.commit();
        session.close();
        return ticket;
    }
}
