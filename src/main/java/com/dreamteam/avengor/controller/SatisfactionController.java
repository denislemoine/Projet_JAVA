package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Satisfaction Controller
 */
@Controller
public class SatisfactionController {

    /**
     * @param model
     * @return
     */
    // Route pour la vue d'ajout d'une satisfaction
    @GetMapping("/satisfaction")
    public String showListIncidents(Model model){
        // On recupère la liste des incidents et on l'envois en variable dans la vue
        List<IncidentModel> incidentList = new ArrayList<>();
        incidentList = Db.getAllIncidents();
        model.addAttribute("incidentList",incidentList);
        // On récupère la liste des super vilains et on l'envois en variable dans la vue
        List<SuperVilainModel> superVilainList = new ArrayList<>();
        superVilainList = Db.getAllVilains();
        model.addAttribute("superVilainList",superVilainList);
        // On récupère la liste des super héros et on l'envois en variable dans la vue
        List<SuperHerosModel> superHeroList = new ArrayList<>();
        superHeroList = Db.getAllHero();
        model.addAttribute("superHeroList",superHeroList);
        // On récupère la liste des missions et on l'envois en variable dans la vue
        List<MissionModel> missionList = new ArrayList<>();
        missionList = Db.getAllMission();
        model.addAttribute("missionList",missionList);
        // On retourne la vue
        return "satisfactionAdd";
    }
    // Route en post pour l'ajout d'une satisfaction
    @RequestMapping(value="/satisfaction-add", method = RequestMethod.POST)
    public String addIncident(WebRequest request) {
        // On récupère les données entré dans le formulaire
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
        // On créer l'objet satisfaction
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
        // On envoi l'objet a la méthode pour enregistrer les données en base
        Db.saveSatisfaction(satisfaction);
        // On redirige vers l'url "satisfaction"
        return "redirect:satisfaction";
    }
}