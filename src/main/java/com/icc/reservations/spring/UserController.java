package com.icc.reservations.spring;

import com.icc.reservations.model.Users;
import com.icc.reservations.service.RolesService;
import com.icc.reservations.service.UsersService;
import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    private RolesService rolesService;

    @Qualifier(value = "usersService")
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Qualifier(value = "rolesService")
    public void setRolesService(RolesService rolesService) {
        this.rolesService = rolesService;
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
        model.addAttribute("userToLogin", new Users());
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("userToRegister", new Users());
        model.addAttribute("languages", getLanguages());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute Users users) {
        if (isUserValid(users)) {
            users.setRoleId(rolesService.getRoleByName("membre"));
            usersService.addUser(users);
        } else {
            model.addAttribute("errorMessage", "Informations manquantes.");
        }
        model.addAttribute("userToRegister", new Users());
        model.addAttribute("languages", getLanguages());
        return "register";
    }

    private boolean isUserValid(Users users) {
        return users.getEmail() != null && !users.getEmail().isEmpty()
                && null != users.getFirstname() && !users.getFirstname().isEmpty()
                && null != users.getLastname() && !users.getLastname().isEmpty()
                && null != users.getPassword() && !users.getPassword().isEmpty()
                && null != users.getLangue() && !users.getPassword().isEmpty();
    }

    private List getLanguages() {
        List<String> languages = new ArrayList<String>();
        languages.add("FR");
        languages.add("NL");
        languages.add("EN");
        return languages;
    }
}
