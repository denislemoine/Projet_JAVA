package com.dreamteam.avengor.controller;

import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    public String adminHome(){
        String login = "admin"; // a changer par la variable contenant le role de l'utilisateur
        if (login == "admin"){
            return "admin";
        } else {
            return "login";
        }

    }
}
