package com.alevelhw.module3.repository;

import com.alevelhw.module3.entity.Sms;
import com.alevelhw.hw24.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SmsRepository {

    public void saveSms(Sms sms) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sms);
        transaction.commit();
        session.close();
    }

    public List<Sms> searchThroughSmsStorageByText(String text) {
        StringBuilder builder = new StringBuilder("select s from Sms s where ");
        String[] splitText = text.split(" ");
        if (splitText.length == 0) {
            throw new IllegalStateException();
        } else if (splitText.length != 1) {
            for (int i = 0; i < splitText.length - 1; i++) {
                builder.append("s.contentSms like '%")
                        .append(splitText[i])
                        .append("%' and ");
            }
        }
        builder.append("s.contentSms like '%")
                .append(splitText[splitText.length - 1])
                .append("%'");
        String query = builder.toString();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Sms> smsList = session
                .createQuery(query, Sms.class)
                .list();
        transaction.commit();
        session.close();
        return smsList;
    }

    public List<Sms> fullTextSearchThroughSmsStorage(String text) {
        StringBuilder builder = new StringBuilder();
        String[] splitText = text.split(" ");
        if (splitText.length == 0) {
            throw new IllegalStateException();
        } else if (splitText.length > 1) {
            for (int i = 0; i < splitText.length - 1; i++) {
                builder.append(splitText[i]).append(" | ");
            }
        }
        builder.append(splitText[splitText.length - 1]);
        String preparedText = builder.toString();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Sms> smsList = session
                .createNativeQuery("select * " +
                        "from activities " +
                        "where to_tsvector('english', content_sms) @@ to_tsquery('english', :text)", Sms.class)
                        .setParameter("text", preparedText)
                        .list();
        transaction.commit();
        session.close();
        return smsList;
    }
}
