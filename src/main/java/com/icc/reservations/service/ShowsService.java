package com.icc.reservations.service;

import com.icc.reservations.model.Shows;
import java.util.List;

/**
 *
 * @author Anthony Roelandts
 */
public interface ShowsService {

    void addShow(Shows s);

    void updateShow(Shows s);

    List<Shows> listShows();

    Shows getShowsById(Integer id);

    void removeShow(Integer id);

    List<Shows> listShowsByCategorieId(Integer id);

}
