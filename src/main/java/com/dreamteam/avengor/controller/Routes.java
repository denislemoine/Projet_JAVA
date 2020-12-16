package com.dreamteam.avengor.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.dreamteam.avengor.controller.IncidentController;

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

//    @GetMapping("/incident")
    // Geré dans le controller IncidentController

    @GetMapping("/admin")
    public String SuperUserHome(){ return "panelAdmin/admin";}

    @GetMapping("/admin/missions")
    public String SuperUserMission(){ return "panelAdmin/missions";}

    @GetMapping("/admin/crise")
    public String SuperUserCrise(){ return "panelAdmin/crise";}

    @GetMapping("/admin/accounts")
    public String SuperUserAccount(){ return "1panelAdmin/accounts";}

    @GetMapping("/admin/organisation")
    public String SuperUserOrga(){ return "panelAdmin/organisations";}



    //===================================================================================
    //                                                                                  =
    //                              POST / GET METHODS                                        =
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
