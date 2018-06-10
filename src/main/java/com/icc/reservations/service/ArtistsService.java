package com.icc.reservations.service;

import java.util.List;

import com.icc.reservations.model.Artists;

public interface ArtistsService {

    void addArtist(Artists a);

    void updateArtist(Artists a);

    List<Artists> listArtists();

    Artists getArtistById(Integer id);

    void removeArtist(Integer id);

}
