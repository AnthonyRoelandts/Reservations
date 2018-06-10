package com.icc.reservations.service;

import com.icc.reservations.model.Users;

/**
 *
 * @author antho
 */
public interface UsersService {

    void addUser(Users u);

    void updateUser(Users u);

    Users getUserById(Integer id);
}
