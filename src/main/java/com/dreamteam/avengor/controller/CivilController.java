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

    @GetMapping("/civil")
    public String showCivilList(Model model){

        listeCivils = CivilsModel.getAllCivils();

        model.addAttribute("civilian",listeCivils);

        return "CivilsList";
    }


}