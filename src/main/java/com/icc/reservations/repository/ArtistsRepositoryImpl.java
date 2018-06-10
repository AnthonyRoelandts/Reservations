package com.icc.reservations.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.icc.reservations.model.Artists;

@Repository
public class ArtistsRepositoryImpl implements ArtistsRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArtistsRepositoryImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addArtist(Artists a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(a);
        LOGGER.info("Artist saved successfully, Details=" + a);
    }

    @Override
    public void updateArtist(Artists a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(a);
        LOGGER.info("Artist updated successfully, Details=" + a);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Artists> listArtists() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Artists> artisstList = session.createQuery("from Artists").list();
        for (Artists p : artisstList) {
            LOGGER.info("Artists List::" + p);
        }
        return artisstList;
    }

    @Override
    public Artists getArtistById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Artists a = (Artists) session.load(Artists.class, id);
        LOGGER.info("Artist loaded successfully, details=" + a);
        return a;
    }

    @Override
    public void removeArtist(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Artists a = (Artists) session.load(Artists.class, id);
        if (null != a) {
            session.delete(a);
        }
        LOGGER.info("Artist deleted successfully, details=" + a);
    }

}
