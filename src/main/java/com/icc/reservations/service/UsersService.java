package com.icc.reservations.service;

import com.icc.reservations.model.Users;

/**
 *
 * @author antho
 */
public interface UsersService {

    Users addUser(Users u);

    void updateUser(Users u);

    Users getUserById(Integer id);
    
    Users getUserByLoginAndDecryptedPassword(String login, String pwd);
}
