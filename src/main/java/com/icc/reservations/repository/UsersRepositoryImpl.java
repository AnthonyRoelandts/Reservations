package com.icc.reservations.repository;

import com.icc.reservations.model.Users;
import java.util.List;
import org.hibernate.Query;
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
    public Users addUser(Users u) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(u);
        return u;
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

    @Override
    public Users getUserByLoginAndDecryptedPassword(String login, String pwd) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from users as u where u.login = :login and u.password = :pwd");
        query.setParameter("login", login);
        query.setParameter("pwd", pwd);
        List list = query.list();
        return (Users) list.get(0);
    }

}
