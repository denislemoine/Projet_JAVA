package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.CivilsModel;
import com.dreamteam.avengor.model.MissionModel;
import com.dreamteam.avengor.model.SuperHerosModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class MissionController {

    private List<MissionModel> missionsList = new ArrayList<>();

    @GetMapping("/mission")
    public String showListHero(Model model){

        missionsList = MissionModel.getAllMissions();
        model.addAttribute("missions", missionsList);

        return "mission/missionList";
    }

    @GetMapping("/mission-add")
    public String showFormAddMission(Model model){

        missionsList = MissionModel.getAllMissions();
        model.addAttribute("missions", missionsList);

        return "mission/missionAdd";
    }


    @RequestMapping(value="/mission-add", method = RequestMethod.POST)
    public String addMission (HttpServletRequest request, CivilsModel civilsModel) throws ParseException {

        String titre = request.getParameter("titre");
        int niveau = Integer.parseInt(request.getParameter("niveau"));
        int urgence = Integer.parseInt(request.getParameter("urgence"));

        Date date = new Date();
        long now = date.getTime();
        Timestamp dateDebut = new Timestamp(now);


        /*Db.getIncidentByID();


        MissionModel mission = new MissionModel(1, titre, dateDebut, null, niveau, urgence, 0, null);
        int id_civil = Db.saveMission(mission);

        */
        return "redirect:mission";
    }


}