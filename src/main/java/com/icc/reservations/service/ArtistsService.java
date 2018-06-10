package com.icc.reservations.service;

import com.icc.reservations.model.Artists;
import java.util.List;

/**
 *
 * @author antho
 */
public interface ArtistsService {

    void addArtist(Artists a);

    void updateArtist(Artists a);

    List<Artists> listArtists();

    Artists getArtistById(Integer id);

    void removeArtist(Integer id);

}
