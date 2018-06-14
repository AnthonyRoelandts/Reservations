package com.icc.reservations.repository;

import com.icc.reservations.model.Locations;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anthony Roelandts
 */
@Repository
public class LocationsRepositoryImpl implements LocationsRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addLocation(Locations l) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(l);
    }

    @Override
    public Locations getLocationsById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Locations) session.load(Locations.class, id);
    }

    @Override
    public void removeLocations(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Locations l = (Locations) session.load(Locations.class, id);
        if (null != l) {
            session.delete(l);
        }
    }

    @Override
    public void updateLocations(Locations l) {
        Session session = sessionFactory.getCurrentSession();
        session.update(l);
    }

    @Override
    public List<Locations> listLocations() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Locations").list();
    }

}
