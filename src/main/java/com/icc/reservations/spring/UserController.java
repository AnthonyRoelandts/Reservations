package com.icc.reservations.spring;

import com.icc.reservations.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 *
 * @author antho
 */
@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @Qualifier(value = "usersService")
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
