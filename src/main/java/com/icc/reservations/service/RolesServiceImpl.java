package com.icc.reservations.service;

import com.icc.reservations.model.Roles;
import com.icc.reservations.repository.RolesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author antho
 */
@Service
@Transactional
public class RolesServiceImpl implements RolesService {

    private RolesRepository rolesRepository;

    public void setRolesRepository(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public Roles getRoleById(Integer id) {
        return rolesRepository.getRoleById(id);
    }

    @Override
    public Roles getRoleByName(String role) {
        return rolesRepository.getRoleByName(role);
    }

}
