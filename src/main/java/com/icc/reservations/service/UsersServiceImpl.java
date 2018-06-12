package com.icc.reservations.service;

import com.icc.reservations.model.Users;
import com.icc.reservations.repository.UsersRepository;
import com.icc.reservations.utils.EncryptionUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author antho
 */
@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public void setUsersRepository(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    
    @Override
    public Users addUser(Users u) {
        try {
            u.setPassword(EncryptionUtils.encrypt(u.getPassword()));
            u = this.usersRepository.addUser(u);
        } catch (Exception ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public void updateUser(Users u) {
        this.usersRepository.updateUser(u);
    }

    @Override
    public Users getUserById(Integer id) {
        Users u = this.usersRepository.getUserById(id);
        try {
            u.setPassword(EncryptionUtils.decrypt(u.getPassword()));
        } catch (Exception ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public Users getUserByLoginAndDecryptedPassword(String login, String pwd) {
        Users u = null;
        try {
            u = this.usersRepository.getUserByLoginAndDecryptedPassword(login, EncryptionUtils.encrypt(pwd));
        } catch (Exception ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

}
