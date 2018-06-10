package com.icc.reservations.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icc.reservations.model.Artists;
import com.icc.reservations.repository.ArtistsRepository;

@Service
public class ArtistsServiceImpl implements ArtistsService {

    private ArtistsRepository artistsRepository;

    public void setArtistsRepository(ArtistsRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    @Override
    @Transactional
    public void addArtist(Artists a) {
        this.artistsRepository.addArtist(a);
    }

    @Override
    @Transactional
    public void updateArtist(Artists a) {
        this.artistsRepository.updateArtist(a);
    }

    @Override
    @Transactional
    public List<Artists> listArtists() {
        return this.artistsRepository.listArtists();
    }

    @Override
    @Transactional
    public Artists getArtistById(Integer id) {
        return this.artistsRepository.getArtistById(id);
    }

    @Override
    @Transactional
    public void removeArtist(Integer id) {
        this.artistsRepository.removeArtist(id);
    }

}
