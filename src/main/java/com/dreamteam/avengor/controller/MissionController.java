package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class MissionController {

    private List<MissionModel> missionsList = new ArrayList<>();
    private List<SuperHerosModel> herosList = new ArrayList<>();

    @GetMapping("/mission")
    public String showListHero(Model model){

        missionsList = MissionModel.getAllMissions();
        model.addAttribute("missions", missionsList);



        return "mission/missionList";
    }

    @RolesAllowed({"CIVIL", "HERO", "ADMIN"})
    @RequestMapping(value="/mission-{id}", method = RequestMethod.GET)
    public String showDetailMission (@PathVariable("id") String id, HttpServletRequest request, Model model) {
        MissionModel mission = Db.findMissionById(id);
        model.addAttribute("mission",mission);

        List<SatisfactionModel> satisfactionList = Db.getSatisfactionByMissionID(id);
        model.addAttribute("satisfactionList",satisfactionList);

        return "mission/missionDetail";
    }

    @RolesAllowed({"ADMIN", "HERO"})
    @GetMapping("/mission-add-{id}")
    public String showFormAddMission(@PathVariable("id") String id, Model model){

        herosList = SuperHerosModel.getAllHeros();

        model.addAttribute("id", id);
        model.addAttribute("herosList", herosList);

        return "mission/missionAdd";
    }

    @RolesAllowed("ADMIN")
    @RequestMapping(value="/mission-add-{id}", method = RequestMethod.POST)
    public String addMission (@PathVariable("id") String id, HttpServletRequest request, CivilsModel civilsModel) {

        String titre = request.getParameter("titre");
        int niveau = Integer.parseInt(request.getParameter("niveau"));
        int urgence = Integer.parseInt(request.getParameter("urgence"));
        int idHero = Integer.parseInt(request.getParameter("hero"));

        Date date = new Date();
        long now = date.getTime();
        Timestamp dateDebut = new Timestamp(now);

        MissionModel mission = new MissionModel(1, titre, dateDebut, null, niveau, urgence, Integer.parseInt(id), null,null);
        Db.saveMission(mission, idHero);

        return "redirect:mission";
    }


}