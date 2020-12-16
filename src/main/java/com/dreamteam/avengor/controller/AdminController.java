package com.dreamteam.avengor.controller;

import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.AdminModel;
import com.dreamteam.avengor.model.CivilsModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private List<CivilsModel> listeCivils = new ArrayList<>();

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
    @GetMapping("/admin/accounts")
    public String adminAccounts(Model model){

        listeCivils = CivilsModel.getAllCivils();

        model.addAttribute("civil",listeCivils);
        return "panelAdmin/accounts";
    }
    @RequestMapping(value = "/admin/accounts/{id}", method = RequestMethod.GET)
    public String deleteAccount(@PathVariable("id") int id,Model model){

        CivilsModel civil = Db.findCivilById(id);
        model.addAttribute("civil",civil);
        return "panelAdmin/deleteAccount";

    }
    public String adminCrise(){
        return "panelAdmin/crise";
    }
    public String adminOrganisation(){
        return "panelAdmin/organisations";
    }
}
