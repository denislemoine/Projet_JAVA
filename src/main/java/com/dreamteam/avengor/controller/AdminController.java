package com.dreamteam.avengor.controller;

import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    public String adminHome(){
        String login = "admin"; // a changer par la variable contenant le role de l'utilisateur
        if (login == "admin"){
            return "panelAdmin/admin";
        } else {
            return "login";
        }

    }
    public String adminMission(){
        return "panelAdmin/missions";
    }
    public String adminAccounts(){
        return "panelAdmin/accounts";
    }
    public String adminCrise(){
        return "panelAdmin/crise";
    }
    public String adminOrganisation(){
        return "panelAdmin/organisations";
    }
}
