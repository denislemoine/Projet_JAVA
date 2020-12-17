package com.dreamteam.avengor.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MissionController {

    @GetMapping("/mission")
    public String showListHero(Model model){

        //missionsList = MissionModel.getAllMissions();

        //model.addAttribute("missions", missionsList);

        return "mission/missionList";
    }

}