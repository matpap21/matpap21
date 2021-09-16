package org.myexample;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao extends EntityDao<User>{

    public List<User> getAll(){
        final Session session = HibernateFactory.getSessionFactory ().openSession ();
        //session.createQuery ("FROM USER", User.class);
        final Query<User> getAllQuerry = session.createQuery ("FROM User", User.class);
        final List<User> resultList = getAllQuerry.getResultList ();
        session.close ();
        return resultList;


    }
}
