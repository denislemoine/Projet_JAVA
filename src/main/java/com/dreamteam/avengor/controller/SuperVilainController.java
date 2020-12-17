package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.SuperHerosModel;
import com.dreamteam.avengor.model.SuperVilainModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@Controller
public class SuperVilainController {

    @RequestMapping(value="/registerVilain", method = RequestMethod.POST)
    public String addSuperHero (HttpServletRequest request, SuperVilainModel superVilainModel) throws ParseException {

        String nom = request.getParameter("nom");
        int IdentiteSecrete = Integer.parseInt(request.getParameter("super_idsec")) ;
        String pouvoir = request.getParameter("super_pouvoir");
        String pontFaible = request.getParameter("super_pfaible");
        //Float score = float request.getParameter(0);
        String commentaire = request.getParameter("commentaire");

        if (request.getParameter("isVilain") == "1"){

        }

        SuperVilainModel superVilainModel1 = new SuperVilainModel(1,nom,IdentiteSecrete,pouvoir,pontFaible,null,commentaire);
        Db.saveVilain(superVilainModel1);
        return "redirect:/login";
    }
}