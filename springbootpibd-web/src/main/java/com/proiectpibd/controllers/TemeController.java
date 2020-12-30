package com.proiectpibd.controllers;

import com.neagumihai.proiectpibddata.service.TemaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/teme")
public class TemeController {

    private final TemaService temaService;

    public TemeController(TemaService temaService) {
        this.temaService = temaService;
    }

    @GetMapping({"/", "", "index", "index.html"})
    public String returnAllTeme(Model model,
                                @RequestParam(name = "offset", required = false, defaultValue = "0") String offset,
                                @RequestParam(name = "action", required = false, defaultValue = "") String action ){


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

        model.addAttribute("teme", temaService.getAll((newOffset - 1) *10, 10));

        return "teme/index";
    }
}
