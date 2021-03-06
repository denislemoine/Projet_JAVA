package com.dreamteam.avengor.controller;

import com.dreamteam.avengor.model.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.dreamteam.avengor.database.Db;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;

/**
 * Incident Controller
 */
@Controller
public class IncidentController {


    /**
     * @param model
     * @return
     */
    @GetMapping("/incident")
    public String showListIncidents(Model model){
        List<IncidentModel> incidentList = new ArrayList<>();
        incidentList = Db.getAllIncidents();
        model.addAttribute("incidentList",incidentList);

        return "incident/incident";
    }

    /**
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/incident-{id}", method = RequestMethod.GET)
    public String deleteIncident (@PathVariable("id") String id, HttpServletRequest request, Model model) {
        IncidentModel incident = Db.getIncidentByID(id);
        model.addAttribute("incident",incident);

        List<SatisfactionModel> satisfactionList = Db.getSatisfactionByIncidentID(id);
        model.addAttribute("satisfactionList",satisfactionList);

        return "incident/incidentDetail";
    }

    /**
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping(value="/incident-add", method = RequestMethod.POST)
    public String addIncident(WebRequest request) throws ParseException {

        String Adresse = request.getParameter("Adresse");
        String TypeIncident = request.getParameter("TypeIncident");
        int id_Civils = Integer.parseInt(request.getParameter("id_Civils"));
        Integer Ennemis = Integer.parseInt(request.getParameter("Ennemis"));
        String InfoComplementaire = request.getParameter("InfoComplementaire");

        if (Ennemis == 0) {
            Ennemis = null;
        }
        
        IncidentModel incident = new IncidentModel(1,Adresse,TypeIncident,id_Civils,Ennemis,null,InfoComplementaire);
        Db.saveIncident(incident);
        return "redirect:incident";
    }

    /**
     * @param model
     * @return
     */
    @RolesAllowed({"HERO", "ADMIN"})
    @GetMapping("/incident-add")
    public String showFormIncident(Model model){
        List<SuperVilainModel> superVilainList = new ArrayList<>();
        superVilainList = Db.getAllVilains();

        model.addAttribute("superVilainList",superVilainList);

        return "incident/incidentAdd";
    }

    /**
     * @param id
     * @param request
     * @return
     */
    @RolesAllowed("ADMIN")
    @RequestMapping(value="/incident-delete-{id}", method = RequestMethod.GET)
    public String deleteIncident (@PathVariable("id") String id, HttpServletRequest request) {
        Db.deleteIncidentByID(id);
        return "redirect:incident";
    }

}