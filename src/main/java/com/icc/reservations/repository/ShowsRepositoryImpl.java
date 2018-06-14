package com.icc.reservations.repository;

import com.icc.reservations.model.Shows;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anthony Roelandts
 */
@Repository
public class ShowsRepositoryImpl implements ShowsRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addShow(Shows s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
    }

    @Override
    public void updateShow(Shows s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(s);
    }

    @Override
    public List<Shows> listShows() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Shows").list();
    }

    @Override
    public Shows getShowsById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Shows) session.load(Shows.class, id);
    }

    @Override
    public void removeShow(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Shows s = (Shows) session.load(Shows.class, id);
        if (null != s) {
            session.delete(s);
        }
    }

    @Override
    public List<Shows> listShowsByCategorieId(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Shows where categorieId = " + id).list();
    }

}
