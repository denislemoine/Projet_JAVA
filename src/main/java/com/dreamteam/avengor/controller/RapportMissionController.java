package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.MissionModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class RapportMissionController {
    private List<MissionModel> missions = new ArrayList<>();

    @GetMapping(value = "/mission/endmission/{id}")
    public String viewRapportMission(@PathVariable("id") String id, Model model){
        MissionModel mission = Db.findMissionById(id);
        model.addAttribute("mission", mission);
        return "mission/missionEnd";
    }

    @RolesAllowed("ADMIN")
    @RequestMapping(value = "/mission/endmission/d", method = RequestMethod.POST)
    public String endMission(HttpServletRequest request, Model model){



        return "missionList";
    }

}
