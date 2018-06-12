package com.icc.reservations.service;

import com.icc.reservations.model.Roles;

/**
 *
 * @author antho
 */
public interface RolesService {

    Roles getRoleById(Integer id);

    Roles getRoleByName(String role);

}
