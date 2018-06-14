package com.icc.reservations.service;

import com.icc.reservations.model.Shows;
import com.icc.reservations.repository.ShowsRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anthony Roelandts
 */
@Service
@Transactional
public class ShowsServiceImpl implements ShowsService {
    
    private ShowsRepository showsRepository;
    
    public void setShowsRepository(ShowsRepository showsRepository) {
        this.showsRepository = showsRepository;
    }
    
    @Override
    public void addShow(Shows s) {
        this.showsRepository.addShow(s);
    }
    
    @Override
    public void updateShow(Shows s) {
        this.showsRepository.updateShow(s);
    }
    
    @Override
    public List<Shows> listShows() {
        return this.showsRepository.listShows();
    }
    
    @Override
    public Shows getShowsById(Integer id) {
        return this.showsRepository.getShowsById(id);
    }
    
    @Override
    public void removeShow(Integer id) {
        this.showsRepository.removeShow(id);
    }
    
    @Override
    public List<Shows> listShowsByCategorieId(Integer id) {
        return this.showsRepository.listShowsByCategorieId(id);
    }
    
}
