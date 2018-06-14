package com.icc.reservations.spring;

import com.icc.reservations.model.Categorie;
import com.icc.reservations.model.Locations;
import com.icc.reservations.model.Shows;
import com.icc.reservations.service.CategorieService;
import com.icc.reservations.service.LocationsService;
import com.icc.reservations.service.ShowsService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controlleur pour gérer ce qui concerne les shows et leurs booking
 *
 * @author Anthony Roelandts
 */
@Controller
public class ShowsController {

    @Autowired
    private ShowsService showsService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private LocationsService locationsService;

    @Qualifier(value = "showsService")
    public void setShowsService(ShowsService showsService) {
        this.showsService = showsService;
    }

    @Qualifier(value = "categorieService")
    public void setCategorieService(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @Qualifier(value = "locationsService")
    public void setLocationsService(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @RequestMapping(value = "/shows", method = RequestMethod.GET)
    public String listArtists(Model model) {
        model.addAttribute("listShows", this.showsService.listShows());
        model.addAttribute("showToAdd", new Shows());
        model.addAttribute("categorieToAdd", new Categorie());
        model.addAttribute("listCategories", this.categorieService.listCategories());
        model.addAttribute("categorieToFilter", new Categorie());
        return "shows";
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String bookShow(Model model, @ModelAttribute Shows show) {
        model.addAttribute("listShows", this.showsService.listShows());
        model.addAttribute("showToAdd", new Shows());
        model.addAttribute("categorieToAdd", new Categorie());
        model.addAttribute("categorieToFilter", new Categorie());
        model.addAttribute("listCategories", this.categorieService.listCategories());
        return "shows";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(Model model, @ModelAttribute Categorie cat) {
        Categorie categorie = categorieService.getCategorieByName(cat.getName());
        model.addAttribute("listShows", this.showsService.listShowsByCategorieId(categorie.getId()));
        model.addAttribute("showToAdd", new Shows());
        model.addAttribute("categorieToAdd", new Categorie());
        model.addAttribute("categorieToFilter", new Categorie());
        model.addAttribute("listCategories", this.categorieService.listCategories());
        return "shows";
    }

    @RequestMapping(value = "/addShow", method = RequestMethod.POST)
    public String addShow(Model model, @ModelAttribute Shows show) {
        if (isValidShow(show)) {
            Locations loc = locationsService.getLocationsById(1);
            show.setLocationId(loc);
            Categorie cat = categorieService.getCategorieByName(show.getCategorieId().getName());
            show.setCategorieId(cat);
            show.setBookable(true);
            show.setPosterUrl("");
            showsService.addShow(show);
            model.addAttribute("successMessage", "Ajout de spectacle effectué avec succès.");
        }
        return "index";
    }

    @RequestMapping(value = "/addCategorie", method = RequestMethod.POST)
    public String addCategorie(Model model, @ModelAttribute Categorie cat) {
        if (null != cat.getName() && !cat.getName().isEmpty() && cat.getName().length() < 11) {
            categorieService.addCategorie(cat);
            model.addAttribute("successMessage", "Ajout de catégorie effectué avec succès.");
        } else {
            model.addAttribute("errorMessage", "La catégorie fourni est invalide. 10 caractères max");
        }
        return "index";
    }

    /**
     * Verify if the show has minimal information
     *
     * @param show the show
     * @return true if acceptable, false if not
     */
    private boolean isValidShow(Shows show) {
        return null != show.getTitle() && !show.getTitle().isEmpty()
                && null != show.getPrice() && (show.getPrice().compareTo(BigDecimal.ZERO) > 0)
                && null != show.getSlug() && !show.getSlug().isEmpty();
    }

    @RequestMapping(value = "/bookAjax", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getAuthentication() {
        return new ResponseEntity<Object>("ok", HttpStatus.OK);
    }

}
