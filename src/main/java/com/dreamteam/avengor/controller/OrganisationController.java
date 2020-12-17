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


    @RequestMapping(value="/organisation-add", method = RequestMethod.POST)
    public String addOrganisation (HttpServletRequest request, OrganisationModel organisationModel) {

        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        int dirigent = Integer.parseInt(request.getParameter("dirigeant"));
        String commentaire = request.getParameter("commentaire");

        Date date = new Date();
        long now = date.getTime();
        Timestamp dateAjout = new Timestamp(now);

        OrganisationModel organisationModel1 = new OrganisationModel(1, nom, adresse, dirigent, commentaire,dateAjout , null, 0, 0);
        Db.saveOrganisation(organisationModel1);
        return "organisation/organisationList";
    }
}