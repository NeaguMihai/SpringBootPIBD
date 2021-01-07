package com.proiectpibd.controllers;

import com.neagumihai.proiectpibddata.decorators.DoublePackage;
import com.neagumihai.proiectpibddata.model.Elev;
import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.model.Tema;
import com.neagumihai.proiectpibddata.service.ElevService;
import com.neagumihai.proiectpibddata.service.ElevTemaService;
import com.neagumihai.proiectpibddata.service.TemaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping({"/informatii"})
public class ElevTemeController {


    private final ElevService elevService;

    private final TemaService temaService;

    private final ElevTemaService elevTemaService;


    public ElevTemeController(ElevService elevService, TemaService temaService, ElevTemaService elevTemaService) {
        this.elevService = elevService;
        this.temaService = temaService;
        this.elevTemaService = elevTemaService;
    }

    @GetMapping({"/{id}/inf0"})
    public String getFirstPage(@PathVariable Integer id, Model model){

        Optional<Elev> returned = elevService.getById(id);
        if (returned.isEmpty()) {
            return "/elev/index";
        }
        List<DoublePackage<String, Tema>> pack = new ArrayList<>();
        List<ElevTema> returnedEt = elevTemaService.getByIdElev(id);
        returnedEt.forEach(e -> {
            pack.add(new DoublePackage<>(temaService.getById(e.getIdTema()).get(), e.getLink_tema()));
        });

        model.addAttribute("elevi", Collections.singletonList(returned.get()));
        model.addAttribute("teme", pack);
        return "informatii/index";
    }

    @GetMapping({"/{id}/adauga"})
    public String adaugaLegatura(@PathVariable Integer id,
                                 Model model,
                                 @RequestParam(name = "offset", required = false, defaultValue = "0") String offset,
                                 @RequestParam(name = "action", required = false, defaultValue = "") String action){

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

        Optional<Elev> returned = elevService.getById(id);
        if (returned.isEmpty()) {
            return "/elev/index";
        }

        List<Integer> temeIds = elevTemaService.getAllIdsTeme(returned.get().getId());
        temeIds.add(0);
        Page<Tema> returnedTeme = temaService.getAllByConstraints(PageRequest.of((newOffset-1),10), temeIds);

        model.addAttribute("elevi", Collections.singletonList(returned.get()));
        model.addAttribute("teme", returnedTeme);
        return "informatii/index";
    }

    @GetMapping("/{id}/adauga/{idTema}")
    public String adaugaTemaElevului(@PathVariable Integer id,
                                     @PathVariable Integer idTema,
                                     Model model) {

        ElevTema elevTema = new ElevTema();

        Optional<Elev> returnedElev = elevService.getById(id);
        Optional<Tema> returnedTema = temaService.getById(idTema);

        if(returnedElev.isEmpty() || returnedTema.isEmpty()) {
            model.addAttribute("status", false);
            return "redirect:/notif";
        }

        elevTema.setElev(returnedElev.get());
        elevTema.setTema(returnedTema.get());

        elevTemaService.saveTema(elevTema);
        model.addAttribute("status", true);
        return "redirect:/informatii/"+id+"/inf0";
    }

    @GetMapping("/{id}/inf0/{idTema}/update")
    public String updateLink(Model model,
                             @PathVariable Integer id,
                             @PathVariable Integer idTema) {
        Optional<ElevTema> returned = elevTemaService.findByIdElevAndIdTema(id, idTema);

        if(returned.isEmpty()) {
            return "redirect:/"+id+"/inf0";
        }
        model.addAttribute("elevTema", returned.get());

        return "/informatii/updateForm";


    }
    @PostMapping("/update")
    public String updateJoin(@Valid @ModelAttribute ElevTema elevTema) {

        elevTemaService.updateElevTema(elevTema);

        return "redirect:/informatii/"+elevTema.getIdElev()+"/inf0";
    }
}
