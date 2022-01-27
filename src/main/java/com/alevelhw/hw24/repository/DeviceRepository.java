package com.alevelhw.hw24.repository;

import com.alevelhw.hw24.util.HibernateUtil;
import com.alevelhw.hw24.entity.Device;
import com.alevelhw.hw24.entity.Factory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DeviceRepository {

    public Device getDeviceById(long id) {
        return HibernateUtil.getSessionFactory()
                .openSession()
                .get(Device.class, id);
    }

    public void saveDevice(Device device) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(device);
        transaction.commit();
        session.close();
    }

    public void updateDevice(Device device) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(device);
        transaction.commit();
        session.close();
    }

    public void deleteDevice(Device device) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(device);
        transaction.commit();
        session.close();
    }

    public List<Device> getDevisesByFactory(Factory factory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Device> criteria = cb.createQuery(Device.class);
        Root<Device> deviceRoot = criteria.from(Device.class);

        criteria.select(deviceRoot).where(
                cb.equal(deviceRoot.get("factory").get("id"), factory.getId()));

        List<Device> deviceList = session.createQuery(criteria).list();
        transaction.commit();
        session.close();
        return deviceList;
    }

    public Long getQuantityDevicesByFactory(Factory factory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Long quantityDevicesByFactory = session.createQuery(
                "select count(d) " +
                        "from Device d " +
                        "where d.factory.id = :factoryId", Long.class)
                .setParameter("factoryId", factory.getId())
                .uniqueResult();

        transaction.commit();
        session.close();
        return quantityDevicesByFactory;
    }

    public BigDecimal getTotalCostDevicesByFactory(Factory factory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        BigDecimal totalCostDevicesByFactory = session.createQuery(
                "select sum(d.price) " +
                        "from Device d " +
                        "where d.factory.id = :factoryId", BigDecimal.class)
                .setParameter("factoryId", factory.getId())
                .uniqueResult();

        transaction.commit();
        session.close();
        return totalCostDevicesByFactory;
    }

    public Map<Long, Long> getTotalQuantityDevicesForEachFactory() {
        Map<Long, Long> totalQuantity = new LinkedHashMap<>();
        FactoryRepository factoryRepository = new FactoryRepository();
        List<Factory> factories = factoryRepository.getAllFactory();
        for (Factory factory : factories) {
            totalQuantity.put(
                    factory.getId(), getQuantityDevicesByFactory(factory));
        }
        return totalQuantity;
    }

    public Map<Integer, BigDecimal> getTotalCostDevicesForEachFactory() {
        Map<Integer, BigDecimal> totalCost = new LinkedHashMap<>();
        FactoryRepository factoryRepository = new FactoryRepository();
        List<Factory> factories = factoryRepository.getAllFactory();
        for (Factory factory : factories) {
            totalCost.put(
                    Math.toIntExact(factory.getId()), getTotalCostDevicesByFactory(factory));
        }
        return totalCost;
    }
}
