package com.dreamteam.avengor.controller;

import com.dreamteam.avengor.model.AdminModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    public String adminAccounts(Model model){


        return "panelAdmin/accounts";
    }
    public String adminCrise(){
        return "panelAdmin/crise";
    }
    public String adminOrganisation(){
        return "panelAdmin/organisations";
    }
}
