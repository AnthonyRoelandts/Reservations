package com.icc.reservations.repository;

import com.icc.reservations.model.Categorie;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anthony Roelandts
 */
@Repository
public class CategorieRepositoryImpl implements CategorieRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addCategorie(Categorie c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
    }

    @Override
    public Categorie getCategorieById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Categorie) session.load(Categorie.class, id);
    }

    @Override
    public void removeCategorie(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Categorie c = (Categorie) session.load(Categorie.class, id);
        if (null != c) {
            session.delete(c);
        }
    }

    @Override
    public void updateCategorie(Categorie c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
    }

    @Override
    public List<Categorie> listCategories() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Categorie").list();
    }

    @Override
    public Categorie getCategorieByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Categorie) session.createQuery("from Categorie where name = '" + name + "'").list().get(0);
    }

}
