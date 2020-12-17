package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.IncidentModel;
import com.dreamteam.avengor.model.MissionModel;
import com.dreamteam.avengor.model.SuperHerosModel;
import com.dreamteam.avengor.model.SuperVilainModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SatisfactionController {

    @GetMapping("/satisfaction")
    public String showListIncidents(Model model){
        List<IncidentModel> incidentList = new ArrayList<>();
        incidentList = Db.getAllIncidents();
        model.addAttribute("incidentList",incidentList);

        List<SuperVilainModel> superVilainList = new ArrayList<>();
        superVilainList = Db.getAllVilains();
        model.addAttribute("superVilainList",superVilainList);

        List<SuperHerosModel> superHeroList = new ArrayList<>();
        superHeroList = Db.getAllHero();
        model.addAttribute("superHeroList",superHeroList);

        List<MissionModel> missionList = new ArrayList<>();
        missionList = Db.getAllMission();
        model.addAttribute("missionList",missionList);

        return "satisfactionAdd";
    }
}