package com.icc.reservations.spring;

import com.icc.reservations.model.Users;
import com.icc.reservations.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("userToLogin", new Users());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute Users users) {
        //validate user, depending of boolean set user in session or set error msg
        Users u = usersService.getUserByLoginAndDecryptedPassword(users.getLogin(), users.getPassword());
        if (null == u) {
            model.addAttribute("errorMessage", "Login ou mot de passe ?rron?.");
        } else {
            model.addAttribute("loggedUser", u);
        }
        return "login";
    }
}
