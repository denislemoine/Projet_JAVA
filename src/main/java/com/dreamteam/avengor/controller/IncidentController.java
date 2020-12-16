package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.model.CivilsModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.dreamteam.avengor.model.IncidentModel;
import com.dreamteam.avengor.database.Db;
import org.springframework.web.context.request.WebRequest;

import javax.validation.constraints.Null;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class IncidentController {

    @RequestMapping(value="/incident", method = RequestMethod.POST)
    public String addIncident(WebRequest request) throws ParseException {
        
        
        String Adresse = request.getParameter("Adresse");
        int TypeIncident = Integer.parseInt(request.getParameter("TypeIncident"));
        int id_Civils = Integer.parseInt(request.getParameter("id_Civils"));
        int Ennemis = Integer.parseInt(request.getParameter("Ennemis"));
        String InfoComplementaire = request.getParameter("InfoComplementaire");
        
        IncidentModel incident = new IncidentModel(1,Adresse,TypeIncident,id_Civils,Ennemis,null,InfoComplementaire);
        Db.saveIncident(incident);
        return "redirect:/interface";
    }

    @GetMapping("/incident")
    public String showFormIncident(Model model){
        int LastID = IncidentModel.getLastId();

        model.addAttribute("LastID",LastID);

        return "incident";
    }

}