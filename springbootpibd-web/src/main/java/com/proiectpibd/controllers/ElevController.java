package com.proiectpibd.controllers;

import com.neagumihai.proiectpibddata.decorators.StatusWraper;
import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.service.ElevService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/elev")
public class ElevController {

    private final ElevService elevService;

    public ElevController(ElevService elevservice) {
        this.elevService = elevservice;
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping({"","/","index"})
    public String searchAll(Model model) {

        model.addAttribute("elev", new Elev());
        model.addAttribute("search", false);
        return "elev/index";
    }

    @GetMapping({"/search"})
    public String afterSarch(Model model,
                             @ModelAttribute("elev") Elev elev) throws ParseException {
        modifyObject(elev);

        List<Elev> elevList = elevService.getBySelects(elev);
        model.addAttribute("elevi", elevList);
        model.addAttribute("search", true);
        return "elev/index";
    }

    @GetMapping({"/{id}/update"})
    public String updateElec(@PathVariable Integer id, Model model) {
        Optional<Elev> returnedElev  =elevService.getById(id);

        if (returnedElev.isPresent()) {
            model.addAttribute("elev", returnedElev.get());
            return "elev/elevCreateUpdateForm";
        }else {
            return "redirect:elev/index";
        }
    }

    @GetMapping({"/{id}/delete"})
    public  String deleteElev(@PathVariable Integer id) {

        elevService.deleteById(id);

        return "redirect:/elev/";
    }

    @PostMapping("/save")
    public String salveazaElev(@ModelAttribute("elev") @Validated  Elev elev,
                               BindingResult bind,
                               RedirectAttributes redirectAttributes){
        if (bind.hasErrors()) {
            return "elev/elevCreateUpdateForm";
        }

        StatusWraper<Boolean> status = new StatusWraper<>();

        status.setStatus(elevService.saveElev(elev));
        redirectAttributes.addAttribute("status", status.isStatus());
        return "redirect:/notif";
    }

    @GetMapping("/creaza")
    public String creazaElev(Model model) {
        model.addAttribute("elev", new Elev());
        return "elev/elevCreateUpdateForm";
    }


    private void modifyObject(Elev elev) {
        if (elev.getScoala().equalsIgnoreCase(""))
            elev.setScoala(null);
        if (elev.getPrenume().equalsIgnoreCase(""))
            elev.setPrenume(null);
        if (elev.getNume().equalsIgnoreCase(""))
            elev.setNume(null);
        if (elev.getClasa().equalsIgnoreCase(""))
            elev.setClasa(null);

    }
}
