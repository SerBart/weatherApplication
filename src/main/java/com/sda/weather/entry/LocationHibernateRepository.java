package com.sda.weather.entry;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@RequiredArgsConstructor
public class LocationHibernateRepository implements LocationRepository {

    private final SessionFactory sessionFactory;


    @Override
    public Location save(Location Location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(Location);
        transaction.commit();
        session.close();
        return Location;

    }
}
