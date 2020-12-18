package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.SuperVilainModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Super Vilain Controller
 */
@Controller
public class SuperVilainController {

    /**
     * @param request
     * @param superVilainModel
     * @return
     * @throws ParseException
     */
    @RolesAllowed("CIVIL")
    @RequestMapping(value="/registerVilain", method = RequestMethod.POST)
    public String addSuperHero (HttpServletRequest request, SuperVilainModel superVilainModel) throws ParseException {

        String nom = request.getParameter("nom");
        int IdentiteSecrete = Integer.parseInt(request.getParameter("super_idsec")) ;
        String pouvoir = request.getParameter("super_pouvoir");
        String pontFaible = request.getParameter("super_pfaible");
        String commentaire = request.getParameter("commentaire");

        if (request.getParameter("isVilain") == "1"){

        }

        SuperVilainModel superVilainModel1 = new SuperVilainModel(1,nom,IdentiteSecrete,pouvoir,pontFaible,null,commentaire);
        Db.saveVilain(superVilainModel1);
        return "redirect:/login";
    }
}