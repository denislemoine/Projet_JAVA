package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.model.CivilsModel;
import  com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.IncidentModel;
import com.dreamteam.avengor.model.SatisfactionModel;
import com.dreamteam.avengor.model.SuperHerosModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SuperHerosController {

    private List<SuperHerosModel> herosList = new ArrayList<>();

    @GetMapping("/hero")
    public String showListHero(Model model){

        herosList = SuperHerosModel.getAllHeros();

        model.addAttribute("heros", herosList);

        return "hero/HeroList";
    }

    @RequestMapping(value="/hero-{id}", method = RequestMethod.GET)
    public String showDetailHero (@PathVariable("id") String id, HttpServletRequest request, Model model) {
        SuperHerosModel hero = Db.findHeroById(Integer.parseInt(id));
        model.addAttribute("hero",hero);

        List<SatisfactionModel> satisfactionList = Db.getSatisfactionByCivilID(String.valueOf(hero.getIdentiteSecrete()));
        model.addAttribute("satisfactionList",satisfactionList);

        return "hero/HeroDetail";
    }

    @RequestMapping(value="/registerHero", method = RequestMethod.POST)
    public String addSuperHero (HttpServletRequest request, SuperHerosModel superHerosModel) throws ParseException {

        String nom = request.getParameter("nom");
        int IdentiteSecrete = Integer.parseInt(request.getParameter("super_idsec")) ;
        String pouvoir = request.getParameter("super_pouvoir");
        String pontFaible = request.getParameter("super_pfaible");
        //Float score = float request.getParameter(0);
        String commentaire = request.getParameter("commentaire");


        if (request.getParameter("isHero") == "1"){

        }

        SuperHerosModel superHerosModel1 = new SuperHerosModel(1,nom,IdentiteSecrete,pouvoir,pontFaible,null,commentaire, null);
        Db.saveHero(superHerosModel1);
        return "redirect:/login";
    }

}