package com.dreamteam.avengor.controller;

import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.CivilsModel;
import com.dreamteam.avengor.model.MissionModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class Routes {

    //===================================================================================
    //                                                                                  =
    //                              POST / GET METHODS                                  =
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

    private List<CivilsModel> listeCivils = new ArrayList<>();

    @RolesAllowed("ADMIN")
    @GetMapping("/roles")
    public String showRoles(Model model){

        listeCivils = CivilsModel.getAllCivils();
        model.addAttribute("civils", listeCivils);

        return "role";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/vilain")
    public String vilain() { return "Vilain"; }

    @RolesAllowed("ADMIN")
    @GetMapping("/admin")
    public String SuperUserHome(){ return "panelAdmin/admin";}

    @RolesAllowed("ADMIN")
    @GetMapping("/admin/crise")
    public String SuperUserCrise(){ return "panelAdmin/crise";}

    @RolesAllowed("ADMIN")
    @GetMapping("/admin/organisation")
    public String SuperUserOrga(){ return "panelAdmin/organisations";}

    @RolesAllowed("ADMIN")
    @RequestMapping(value="/role-update-{id}", method = RequestMethod.POST)
    public String addMission (@PathVariable("id") String idUser, HttpServletRequest request, CivilsModel civilsModel) {

        int newRoleId = Integer.parseInt(request.getParameter("role"));

        Db.updatePrivilege(idUser, newRoleId);

        return "redirect:roles";
    }



}
