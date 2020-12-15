package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.model.CivilsModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class CivilController {
    private List<CivilsModel> listeCivils = new ArrayList<>();

    @GetMapping("/civilslist")
    public String showCivilList(Model model){

        CivilsModel civil1 = new CivilsModel(1,"Dupont",null,null,null,null,null,null,null);
        CivilsModel civil2 = new CivilsModel(2,"Dupuit",null,null,null,null,null,null,null);

        listeCivils.add(civil1);
        listeCivils.add(civil2);

        model.addAttribute("civilian",listeCivils);

        return "CivilsList";
    }
}