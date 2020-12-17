package com.dreamteam.avengor.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class Routes {

    @Value("${welcome.message}")
    private String message;

    //===================================================================================
    //                                                                                  =
    //                              GET  METHODS                                        =
    //                                                                                  =
    //===================================================================================

    @GetMapping("/interface")
    public String showInterface() {
        return "interface";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/vilain")
    public String vilain() { return "Vilain"; }

    @GetMapping("/organisation")
    public String organisation() {
        return "organisation/organisationList";
    }

    @GetMapping("/organisation-add")
    public String organisationAdd() {
        return "organisation/organisation";
    }

    @GetMapping("/admin")
    public String SuperUserHome(){ return "panelAdmin/admin";}

    @GetMapping("/admin/missions")
    public String SuperUserMission(){ return "panelAdmin/missions";}

    @GetMapping("/admin/crise")
    public String SuperUserCrise(){ return "panelAdmin/crise";}


    @GetMapping("/admin/organisation")
    public String SuperUserOrga(){ return "panelAdmin/organisations";}



    //===================================================================================
    //                                                                                  =
    //                              POST / GET METHODS                                  =
    //                                                                                  =
    //===================================================================================

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }

}
