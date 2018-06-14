package com.icc.reservations.service;

import com.icc.reservations.model.Categorie;
import java.util.List;

/**
 *
 * @author Anthony Roelandts
 */
public interface CategorieService {

    void addCategorie(Categorie c);

    Categorie getCategorieById(Integer id);

    Categorie getCategorieByName(String name);

    void removeCategorie(Integer id);

    void updateCategorie(Categorie c);

    List<Categorie> listCategories();

}
