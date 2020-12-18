package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import com.dreamteam.avengor.model.MissionModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import java.util.List;

/**
 * Rapport Mission Controller
 */
@Controller
public class RapportMissionController {

    /**
     * List Missions
     */
    private List<MissionModel> missions = new ArrayList<>();

    /**
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/mission/endmission/{id}")
    public String viewRapportMission(@PathVariable("id") String id, Model model){
        MissionModel mission = Db.findMissionById(id);
        model.addAttribute("mission", mission);
        return "mission/missionEnd";
    }

    /**
     * @param request
     * @param model
     * @return
     */
    @RolesAllowed("ADMIN")
    @RequestMapping(value = "/mission/endmission/d", method = RequestMethod.POST)
    public String endMission(HttpServletRequest request, Model model){
        if(request.getParameter("rapport")!= null){
            Db.finishMission(request.getParameter("rapport"),request.getParameter("commentaire"));
        }
        List<MissionModel> missionsList = MissionModel.getAllMissions();
        model.addAttribute("missions",missionsList);
        return "mission/missionList";
    }

}
