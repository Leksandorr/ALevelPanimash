package com.alevelhw.hw24.repository;

import com.alevelhw.hw24.util.HibernateUtil;
import com.alevelhw.hw24.entity.Factory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FactoryRepository {

    public Factory getFactoryById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Factory factory = session.get(Factory.class, id);
        transaction.commit();
        session.close();
        return factory;
    }

    public void saveFactory(Factory factory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(factory);
        transaction.commit();
        session.close();
    }

    public List<Factory> getAllFactory() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Factory> factoryList = session
                .createQuery("select f from Factory f", Factory.class).list();
        transaction.commit();
        session.close();
        return factoryList;
    }
}
