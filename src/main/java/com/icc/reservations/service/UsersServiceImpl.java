package com.icc.reservations.service;

import com.icc.reservations.model.Users;
import com.icc.reservations.repository.UsersRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author antho
 */
@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Override
    public void addUser(Users u) {
        this.usersRepository.addUser(u);
    }

    @Override
    public void updateUser(Users u) {
        this.usersRepository.updateUser(u);
    }

    @Override
    public Users getUserById(Integer id) {
        return this.usersRepository.getUserById(id);
    }

}
