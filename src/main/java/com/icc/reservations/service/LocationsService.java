package com.icc.reservations.service;

import com.icc.reservations.model.Locations;
import java.util.List;

/**
 *
 * @author Anthony Roelandts
 */
public interface LocationsService {

    void addLocation(Locations l);

    Locations getLocationsById(Integer id);

    void removeLocations(Integer id);

    void updateLocations(Locations l);

    List<Locations> listLocations();
}
