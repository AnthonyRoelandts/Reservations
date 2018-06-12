package com.icc.reservations.service;

import com.icc.reservations.model.Artists;
import com.icc.reservations.repository.ArtistsRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArtistsServiceImpl implements ArtistsService {

    private ArtistsRepository artistsRepository;

    public void setArtistsRepository(ArtistsRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    @Override
    public void addArtist(Artists a) {
        this.artistsRepository.addArtist(a);
    }

    @Override
    public void updateArtist(Artists a) {
        this.artistsRepository.updateArtist(a);
    }

    @Override
    public List<Artists> listArtists() {
        return this.artistsRepository.listArtists();
    }

    @Override
    public Artists getArtistById(Integer id) {
        return this.artistsRepository.getArtistById(id);
    }

    @Override
    public void removeArtist(Integer id) {
        this.artistsRepository.removeArtist(id);
    }

}
