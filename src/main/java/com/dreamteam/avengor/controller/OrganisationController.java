package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.CivilsModel;
import com.dreamteam.avengor.model.OrganisationModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class OrganisationController {

    private List<OrganisationModel> listeOrga = new ArrayList<>();

    @GetMapping("/organisation")
    public String organisation(Model model) {

        listeOrga = Db.getAllOrganisations();

        model.addAttribute("organisations", listeOrga);
        return "organisation/organisationList";
    }



    private List<CivilsModel> listeCivils = new ArrayList<>();

    @GetMapping("/organisation-add")
    public String organisationAdd(Model model) {

        listeCivils = CivilsModel.getAllCivils();

        model.addAttribute("civilList", listeCivils);

        return "organisation/organisation";
    }

    @RequestMapping(value="/organisation-add", method = RequestMethod.POST)
    public String addOrganisation (HttpServletRequest request) {

        String nom = request.getParameter("Nom");
        String adresse = request.getParameter("Adresse");
        int civilDirigeant = Integer.parseInt(request.getParameter("Dirigeant"));
        String commentaire = request.getParameter("Commentaire");

        Date date = new Date();
        long now = date.getTime();
        Timestamp dateAjout = new Timestamp(now);

        OrganisationModel organisation = new OrganisationModel(0, nom, adresse, civilDirigeant, commentaire, dateAjout,
                dateAjout, 0, 0);

        Db.saveOrganisation(organisation);
        return "organisation/organisationList";
    }
}