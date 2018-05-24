package favmovieslibrary.omdb.controllers;

import favmovieslibrary.omdb.domain.SearchInstance;
import favmovieslibrary.omdb.services.DBFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmController {
    private String redirectHome = "redirect:home";

    @Autowired
    private DBFilmService filmService;

    @RequestMapping("/add")
    public String add() {
        String id = SearchInstance.getInstance().getId();
        filmService.add(id);
        return redirectHome;
    }

    @RequestMapping("/remove")
    public String remove(Model model) {
        model.addAttribute("films", filmService.displayAll());
        return "removetem";
    }

    @RequestMapping("/removeFilm")
    public String remove(@RequestParam Long id) {
        filmService.remove(id);
        return redirectHome;
    }

    @RequestMapping("redirect:home")
    public String redirectHome() {
        return redirectHome;
    }

    @RequestMapping("home")
    public String displayAllFilms(Model model) {
        model.addAttribute("films", filmService.displayAll());

        if (filmService.displayAll().isEmpty()) {
            return "homeEmpty";
        } else {
            return "home";
        }
    }
}
