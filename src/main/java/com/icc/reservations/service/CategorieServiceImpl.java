package com.icc.reservations.service;

import com.icc.reservations.model.Categorie;
import com.icc.reservations.repository.CategorieRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Anthony Roelandts
 */
@Service
@Transactional
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;

    public void setCategorieRepository(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public void addCategorie(Categorie c) {
        this.categorieRepository.addCategorie(c);
    }

    @Override
    public Categorie getCategorieById(Integer id) {
        return this.categorieRepository.getCategorieById(id);
    }

    @Override
    public void removeCategorie(Integer id) {
        this.categorieRepository.removeCategorie(id);
    }

    @Override
    public void updateCategorie(Categorie c) {
        this.categorieRepository.updateCategorie(c);
    }

    @Override
    public List<Categorie> listCategories() {
        return this.categorieRepository.listCategories();
    }

    @Override
    public Categorie getCategorieByName(String name) {
        return this.categorieRepository.getCategorieByName(name);
    }

}
