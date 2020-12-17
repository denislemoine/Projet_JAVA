package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.model.CivilsModel;
import  com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.SuperHerosModel;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public String addCivils (HttpServletRequest request, CivilsModel civilsModel) throws ParseException {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int civilite = Integer.parseInt(request.getParameter("civilite"));
        String adresse = request.getParameter("adresse");
        String email = request.getParameter("mail");
        String tel = request.getParameter("tel");
        String nationalite = request.getParameter("nationalite");
        String dateDeNaissance = request.getParameter("birth");
        String password = request.getParameter("password");


        String civ = null;
        if (civilite == 0){
          civ = "H";
        }else{ civ = "F"; }



        CivilsModel civilsModel1 = new CivilsModel(1,nom,prenom,civ,adresse,email,tel,dateDeNaissance,password, nationalite);
        int id_civil = Db.saveCivil(civilsModel1);

        if (request.getParameter("isHero") == "1"){
            SuperHerosModel superHerosModel = new SuperHerosModel(1,request.getParameter("super_name"),id_civil,request.getParameter("super_pouvoir"),
                    request.getParameter("super_pfaible"), (float) 0,null,civilsModel1);
            Db.saveHero(superHerosModel);
        }
        return "redirect:/login";
    }

}