package com.dreamteam.avengor.controller;

import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.CivilsModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class Routes {

    //===================================================================================
    //                                                                                  =
    //                              GET  METHODS                                        =
    //                                                                                  =
    //===================================================================================

    @GetMapping("/")
    public String showInterface(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String mail = ((UserDetails)principal).getUsername();
            CivilsModel user = Db.findCivilByMail(mail);
            model.addAttribute("user", user);
        } else {
            String mail = principal.toString();
            CivilsModel user = Db.findCivilByMail(mail);
            model.addAttribute("user", user);
        }

        return "home";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/vilain")
    public String vilain() { return "Vilain"; }

    @GetMapping("/admin")
    public String SuperUserHome(){ return "panelAdmin/admin";}


    @GetMapping("/admin/crise")
    public String SuperUserCrise(){ return "panelAdmin/crise";}


    @GetMapping("/admin/organisation")
    public String SuperUserOrga(){ return "panelAdmin/organisations";}



    //===================================================================================
    //                                                                                  =
    //                              POST / GET METHODS                                  =
    //                                                                                  =
    //===================================================================================

}
