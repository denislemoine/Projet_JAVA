package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.model.MissionModel;
import com.dreamteam.avengor.model.SuperHerosModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
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
    public String addHero(Model model){

        missionsList = MissionModel.getAllMissions();
        model.addAttribute("missions", missionsList);

        return "mission/missionAdd";
    }


}