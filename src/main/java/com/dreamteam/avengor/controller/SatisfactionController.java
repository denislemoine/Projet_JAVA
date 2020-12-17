package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.text.ParseException;
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

    @RequestMapping(value="/satisfaction-add", method = RequestMethod.POST)
    public String addIncident(WebRequest request) {

        String satisfactionType = request.getParameter("type");
        Integer id_Civils = Integer.parseInt(request.getParameter("hero"));
        Integer id_super_vilain = Integer.parseInt(request.getParameter("vilain"));
        Integer id_incidents = Integer.parseInt(request.getParameter("incident"));
        Integer id_mission = Integer.parseInt(request.getParameter("mission"));
        Integer note = Integer.parseInt(request.getParameter("note"));
        String message = request.getParameter("message");
        String commentaire = request.getParameter("commentaire");

        if (id_Civils == 0)                 { id_Civils = null;         }
        if (id_super_vilain == 0)           { id_super_vilain = null;   }
        if (id_incidents == 0)              { id_incidents = null;      }
        if (id_mission == 0)                { id_mission = null;        }
        if ((note == 0 && id_incidents != null) || (note == 0 && id_mission != null))
                                            { note = null;              }

        SatisfactionModel satisfaction = new SatisfactionModel(
                1
                ,id_Civils
                ,id_super_vilain
                ,id_incidents
                ,id_mission
                ,satisfactionType
                ,message
                ,note
                ,commentaire
                );
        Db.saveSatisfaction(satisfaction);
        return "redirect:satisfaction";
    }
}