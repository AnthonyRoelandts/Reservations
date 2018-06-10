package com.icc.reservations.repository;

import com.icc.reservations.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author antho
 */
@Repository
public class UsersRepositoryImpl implements UsersRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addUser(Users u) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(u);
    }

    @Override
    public void updateUser(Users u) {
        Session session = sessionFactory.getCurrentSession();
        session.update(u);
    }

    @Override
    public Users getUserById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Users) session.load(Users.class, id);
    }

}
