package com.icc.reservations.repository;

import com.icc.reservations.model.Users;

/**
 *
 * @author antho
 */
public interface UsersRepository {

    Users addUser(Users u);

    void updateUser(Users u);

    Users getUserById(Integer id);

    Users getUserByLoginAndDecryptedPassword(String login, String pwd);
}
