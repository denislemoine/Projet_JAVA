package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.CivilsModel;
import com.dreamteam.avengor.model.OrganisationModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Organisation Controller
 */
@Controller
public class OrganisationController {

    private List<OrganisationModel> listeOrga = new ArrayList<>();

    /**
     * @param model
     * @return
     */
    @GetMapping("/organisation")
    public String organisation(Model model) {

        listeOrga = Db.getAllOrganisations();

        model.addAttribute("organisations", listeOrga);
        return "organisation/organisationList";
    }


    /**
     * Liste Civils
     */
    private List<CivilsModel> listeCivils = new ArrayList<>();

    /**
     * @param model
     * @return
     */
    @RolesAllowed({"HERO", "ADMIN"})
    @GetMapping("/organisation-add")
    public String organisationAdd(Model model) {

        listeCivils = CivilsModel.getAllCivils();

        model.addAttribute("civilList", listeCivils);

        return "organisation/organisation";
    }

    /**
     * @param request
     * @return
     */
    @RolesAllowed("ADMIN")
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