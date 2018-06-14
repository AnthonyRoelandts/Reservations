package com.icc.reservations.service;

import com.icc.reservations.model.Locations;
import com.icc.reservations.repository.LocationsRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Anthony Roelandts
 */
@Service
@Transactional
public class LocationsServiceImpl implements LocationsService {

    private LocationsRepository locationsRepository;

    public void setLocationsRepository(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    @Override
    public void addLocation(Locations l) {
        locationsRepository.addLocation(l);
    }

    @Override
    public Locations getLocationsById(Integer id) {
        return locationsRepository.getLocationsById(id);
    }

    @Override
    public void removeLocations(Integer id) {
        locationsRepository.removeLocations(id);
    }

    @Override
    public void updateLocations(Locations l) {
        locationsRepository.updateLocations(l);
    }

    @Override
    public List<Locations> listLocations() {
        return locationsRepository.listLocations();
    }

}
