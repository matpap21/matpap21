package org.myexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MoviesDao {
    public Movies save(Movies movie) {


        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory ( );
        final Session session = sessionFactory.openSession ( );
        final Transaction transaction = session.beginTransaction ( );
        final Long saveId = (Long) session.save (movie) ;

        transaction.commit ( );
        final Movies movieFromDB = session.get (Movies.class,saveId);
        session.close ( );
        return movieFromDB;

    }

    public Movies getById(Long id) {
        final Session session = HibernateFactory.getSessionFactory ( ).openSession ( );
        Movies movie = session.get (Movies.class, id);
        session.close ( );
        return movie;
    }

    //remove

    public void removeId(Long id) {
        final Session session = HibernateFactory.getSessionFactory ( ).openSession ( );

        Transaction finding = session.beginTransaction ( );

        Movies movieToBeRemoved = session.get (Movies.class, id);
        session.remove (movieToBeRemoved);
        finding.commit ( );
        session.close ( );
    }


    public Movies remove(Long movie_id) {
        final Session session = HibernateFactory.getSessionFactory ( ).openSession ( );
        final Transaction transaction = session.beginTransaction ( );
        final Movies movie = session.get (Movies.class, movie_id);

        session.remove (movie);
        transaction.commit ( );
        session.close ( );
        return movie;
    }

    public void update(Movies movie){
        final Session session = HibernateFactory.getSessionFactory ().openSession ();
        final Transaction transaction = session.beginTransaction ();
        session.update (movie);
        transaction.commit ();
        session.close ();
        return;

    }
}
