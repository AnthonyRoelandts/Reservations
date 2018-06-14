package com.icc.reservations.repository;

import com.icc.reservations.model.Shows;
import java.util.List;

/**
 *
 * @author Anthony Roelandts
 */
public interface ShowsRepository {

    void addShow(Shows s);

    void updateShow(Shows s);

    List<Shows> listShows();

    Shows getShowsById(Integer id);

    void removeShow(Integer id);

    List<Shows> listShowsByCategorieId(Integer id);

}
