package com.alevelhw.module3.repository;

import com.alevelhw.module3.entity.Subscriber;
import com.alevelhw.hw24.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SubscriberRepository {

    public Subscriber getSubscriberById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Subscriber subscriber = session.get(Subscriber.class, id);
        transaction.commit();
        session.close();
        return subscriber;
    }

    public void saveSubscriber(Subscriber subscriber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(subscriber);
        transaction.commit();
        session.close();
    }

    public void deleteSubscriber(Subscriber subscriber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(subscriber);
        transaction.commit();
        session.close();
    }
}
