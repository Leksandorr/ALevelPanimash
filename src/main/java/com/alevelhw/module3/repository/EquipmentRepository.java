package com.alevelhw.module3.repository;

import com.alevelhw.hw24.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.*;

public class EquipmentRepository {

    public Map<String, Long> getMostPopularEquipment() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Map<String, Long> subscribes = new LinkedHashMap<>();
        Query query = session.createQuery("select e.model, count(e.model) as c " +
                        "from Equipment as e " +
                        "group by e.model " +
                        "order by count(e.model) desc")
                .setMaxResults(1);
        for(Iterator iterator = query.iterate(); iterator.hasNext();) {
            Object[] row = (Object[]) iterator.next();
            subscribes.put((String) row[0], (Long) row[1]);
        }
        transaction.commit();
        session.close();
        return subscribes;
    }
}
