package com.proiectpibd.controllers;

import com.neagumihai.proiectpibddata.decorators.StatusWraper;
import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.model.Tema;
import com.neagumihai.proiectpibddata.service.TemaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/teme")
public class TemeController {

    private final TemaService temaService;
    private static final String TEMACREATEUPDATEFORM = "temaCreateUpdateForm";
    private static final Boolean isAdmin = false;


    public TemeController(TemaService temaService) {
        this.temaService = temaService;
    }

    @GetMapping({"/", "", "index", "index.html"})
    public String returnAllTeme(Model model,
                                @RequestParam(name = "offset", required = false, defaultValue = "0") String offset,
                                @RequestParam(name = "action", required = false, defaultValue = "") String action){

        model.addAttribute("tema", new Tema());
        int newOffset = 0;
        if (action.equalsIgnoreCase("left")) {
            newOffset = Integer.parseInt(offset);
            if(newOffset > 0) {
                newOffset --;
            }
            model.addAttribute("offset", newOffset);
        }else if(action.equalsIgnoreCase("right")){
            newOffset = Integer.parseInt(offset);
            newOffset ++;
            model.addAttribute("offset", newOffset);

        }

        if(newOffset == 0) {
            newOffset ++;
            model.addAttribute("offset", newOffset);
        }

        model.addAttribute("teme", temaService.getAll(PageRequest.of(newOffset-1, 10)));
        model.addAttribute("search", false);
        return "teme/index";
    }

    @GetMapping({"/nou"})
    public String createTema(Model model) {
        model.addAttribute("tema", new Tema());
        return "teme/" + TEMACREATEUPDATEFORM;
    }

    @PostMapping("/save")
    public String saveOrUpdate(@Valid @ModelAttribute("tema")  Tema tema,
                               BindingResult bind,
                               RedirectAttributes redirectAttributes) {
        if (bind.hasErrors()) {

            return "teme/" + TEMACREATEUPDATEFORM;
        }
        StatusWraper<Boolean> status = new StatusWraper<>();
        status.setStatus(temaService.saveTema(tema));

        redirectAttributes.addAttribute("status", status.isStatus());

        return "redirect:/notif";

    }
    @GetMapping({"/search"})
    public String searchSpecific(Model model, @ModelAttribute Tema tema) {
        if(tema.getNumeTema().equalsIgnoreCase(""))
            tema.setNumeTema(null);
        if(tema.getNumeCulegere().equalsIgnoreCase(""))
            tema.setNumeCulegere(null);
        List<Tema> temaResult = temaService.getBySelects(tema);
        model.addAttribute("teme", temaResult);
        model.addAttribute("search", true);
        return "teme/index";
    }

    @GetMapping("/{id}/update")
    public String updateTema(@PathVariable Integer id, Model model) {
        Optional<Tema> returnedTema = temaService.getById(id);

        if(returnedTema.isPresent()) {
            model.addAttribute("tema", returnedTema.get());
            return "teme/"+TEMACREATEUPDATEFORM;
        }else {
            return "redirect:teme/index";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteTema(@PathVariable Integer id) {
        temaService.deleteById(id);
        return "redirect:/teme/";
    }
}
