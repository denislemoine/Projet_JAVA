package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.model.CivilsModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.dreamteam.avengor.model.IncidentModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class IncidentController {

    @RequestMapping(value="/incident", method = RequestMethod.POST)
    public String addIncident(IncidentModel incidentModel){


        return "/";
    }

}