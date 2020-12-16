package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.model.CivilsModel;
import  com.dreamteam.avengor.database.Db;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String addCivils (HttpServletRequest request, CivilsModel civilsModel) {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int id_Civils = Integer.parseInt(request.getParameter("id_Civils"));
        int civilite = Integer.parseInt(request.getParameter("civilite"));
        String adresse = request.getParameter("adresse");
        String email = request.getParameter("mail");
        String tel = request.getParameter("tel");
        String nationalite = request.getParameter("nationalite");
       // String dateDeNaissance = request.getParameter("birth");
        String password = request.getParameter("password");


        CivilsModel civilsModel1 = new CivilsModel(id_Civils,nom,prenom,civilite,adresse,email,tel,dateDeNaissance,password);
        Db.saveCivil(civilsModel1);
        return "/login";
    }

}