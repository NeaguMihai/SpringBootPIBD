package com.proiectpibd.controllers;

import com.neagumihai.proiectpibddata.decorators.StatusWraper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping({"/", "", "index.html", "index.jsp", "index"})
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping({"/notif"})
    public String Result(@ModelAttribute StatusWraper<Boolean> status, Model model) {

        model.addAttribute("status",status.isStatus());
        return "saveOrUpdateResult";
    }


}
