package com.alevelhw.hw24.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory;// настройка и работа с сессиями (фабрика сессий)

    static {
  //      sessionFactory = new Configuration().configure().buildSessionFactory();
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()// получение реестра сервисов (что такое Service - http://docs.jboss.org/hibernate/orm/5.1/integrationsGuide/html_single/)
                .configure() // настройки из hibernate.cfg.xml
                .build();
        try {
            // MetadataSources - для работы с метаданными маппинга объектов
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had troubled building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
