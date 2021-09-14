package org.myexample;

import org.myexample.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EntityDao<T> {
    public T save(T movie, Class<T> classType){
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        final Long savedId = (Long)session.save(movie);
        transaction.commit();
        final T movieFromDb = session.get(classType, savedId);
        session.close();
        return movieFromDb;
    }

    public T getById(Long id, Class<T> classType){
        final Session session = HibernateFactory.getSessionFactory()
                .openSession();
        T movie = session.get(classType, id);
        session.close();
        return movie;
    }

    public T remove(Long id, Class<T> classType){
        final Session session = HibernateFactory.getSessionFactory()
                .openSession();
        final Transaction transaction = session.beginTransaction();
        final T movie = session.get(classType, id);
        session.remove(movie);
        transaction.commit();
        session.close();
        return movie;
    }

    public void update(T movie){
        final Session session = HibernateFactory.getSessionFactory()
                .openSession();
        final Transaction transaction = session.beginTransaction();
        session.update(movie);
        transaction.commit();
        session.close();
    }

}
