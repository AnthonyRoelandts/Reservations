package com.icc.reservations.repository;

import com.icc.reservations.model.Artists;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistsRepositoryImpl implements ArtistsRepository {
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addArtist(Artists a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(a);
    }

    @Override
    public void updateArtist(Artists a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(a);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Artists> listArtists() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Artists").list();
    }

    @Override
    public Artists getArtistById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Artists a = (Artists) session.load(Artists.class, id);
        return a;
    }

    @Override
    public void removeArtist(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Artists a = (Artists) session.load(Artists.class, id);
        if (null != a) {
            session.delete(a);
        }
    }

}
