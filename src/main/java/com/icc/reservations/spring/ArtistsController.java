package com.icc.reservations.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icc.reservations.model.Artists;
import com.icc.reservations.service.ArtistsService;

@Controller
public class ArtistsController {

    @Autowired
    private ArtistsService artistsService;

    @Qualifier(value = "artistsService")
    public void setArtistsService(ArtistsService artistsService) {
        this.artistsService = artistsService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listArtists(Model model) {
        model.addAttribute("artist", new Artists());
        model.addAttribute("listArtists", this.artistsService.listArtists());
        return "artists";
    }

    //For add and update artist both
    @RequestMapping(value = "/artist/add", method = RequestMethod.POST)
    public String addArtist(@ModelAttribute("artist") Artists a) {

        if (a.getId() == 0) {
            //new artist, add it
            this.artistsService.addArtist(a);
        } else {
            //existing artist, call update
            this.artistsService.updateArtist(a);
        }

        return "redirect:/artists";

    }

    @RequestMapping("/remove/{id}")
    public String removeArtist(@PathVariable("id") int id) {

        this.artistsService.removeArtist(id);
        return "redirect:/artists";
    }

    @RequestMapping("/edit/{id}")
    public String editArtist(@PathVariable("id") int id, Model model) {
        model.addAttribute("artist", this.artistsService.getArtistById(id));
        model.addAttribute("listArtists", this.artistsService.listArtists());
        return "artists";
    }

}
