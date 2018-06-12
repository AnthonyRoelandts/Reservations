package com.icc.reservations.repository;

import com.icc.reservations.model.Roles;
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
public class RolesRepositoryImpl implements RolesRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Roles getRoleById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Roles) session.load(Roles.class, id);
    }

    @Override
    public Roles getRoleByName(String role) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Roles where role = :role");
        query.setParameter("role", role);
        List list = query.list();
        return (Roles) list.get(0);
    }
}
