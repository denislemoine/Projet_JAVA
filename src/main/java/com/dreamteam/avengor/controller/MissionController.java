package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.CivilsModel;
import com.dreamteam.avengor.model.IncidentModel;
import com.dreamteam.avengor.model.MissionModel;
import com.dreamteam.avengor.model.SuperHerosModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/mission-add-{id}")
    public String showFormAddMission(@PathVariable("id") String id, Model model){

        herosList = SuperHerosModel.getAllHeros();

        model.addAttribute("id", id);
        model.addAttribute("herosList", herosList);

        return "mission/missionAdd";
    }


    @RequestMapping(value="/mission-add-{id}", method = RequestMethod.POST)
    public String addMission (@PathVariable("id") String id, HttpServletRequest request, CivilsModel civilsModel) {

        String titre = request.getParameter("titre");
        int niveau = Integer.parseInt(request.getParameter("niveau"));
        int urgence = Integer.parseInt(request.getParameter("urgence"));
        int idHero = Integer.parseInt(request.getParameter("hero"));

        Date date = new Date();
        long now = date.getTime();
        Timestamp dateDebut = new Timestamp(now);

        MissionModel mission = new MissionModel(1, titre, dateDebut, null, niveau, urgence, Integer.parseInt(id), null);
        Db.saveMission(mission, idHero);

        return "redirect:mission";
    }


}