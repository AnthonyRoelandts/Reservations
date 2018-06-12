package com.icc.reservations.repository;

import com.icc.reservations.model.Roles;

/**
 *
 * @author antho
 */
public interface RolesRepository {

    Roles getRoleById(Integer id);

    Roles getRoleByName(String role);
}
