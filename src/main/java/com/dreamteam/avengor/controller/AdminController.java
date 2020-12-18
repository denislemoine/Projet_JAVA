package com.dreamteam.avengor.controller;

import com.dreamteam.avengor.model.AdminModel;
import com.dreamteam.avengor.model.CivilsModel;
import com.dreamteam.avengor.model.MissionModel;
import com.dreamteam.avengor.model.OrganisationModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Admin Controller
 */
@Controller
public class AdminController {

    private List<CivilsModel> listeCivils = new ArrayList<>();
    private List<MissionModel> listeMissions = new ArrayList<>();
    private List<OrganisationModel> listeOrga = new ArrayList<>();

    /**
     * @return
     */
    public String adminHome(){
        String login = "admin"; // a changer par la variable contenant le role de l'utilisateur
        if (login == "admin"){
            return "panelAdmin/admin";
        } else {
            return "login";
        }

    }

    /**
     * @param model
     * @return
     */
    @RolesAllowed("ADMIN")
    @GetMapping("/admin/accounts")
    public String adminAccounts(Model model){

        listeCivils = CivilsModel.getAllCivils();

        model.addAttribute("civil",listeCivils);
        return "panelAdmin/accounts";
    }

    /**
     * @param request
     * @param model
     * @return
     * @throws ParseException
     */
    @RolesAllowed("ADMIN")
    @RequestMapping(value = "/admin/accounts/d", method = RequestMethod.POST)
    public String deleteAccount(HttpServletRequest request,Model model) throws ParseException {
        if(request.getParameter("delete")!= null){
            AdminModel.deleteCivil(request.getParameter("delete"));
            listeCivils = CivilsModel.getAllCivils();
            model.addAttribute("civil",listeCivils);
        }
        return "panelAdmin/accounts";
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @RolesAllowed("ADMIN")
    @RequestMapping(value = "/admin/deleteaccounts/{id}")
    public String viewDeleteAccount(@PathVariable("id") String id,Model model){

        CivilsModel civil = AdminModel.findCivilById(id);
        model.addAttribute("civil",civil);
        return "panelAdmin/deleteAccount";

    }

    /**
     * @param request
     * @param model
     * @return
     * @throws ParseException
     */
    @RolesAllowed("ADMIN")
    @RequestMapping(value = "/admin/accounts/m", method = RequestMethod.POST)
    public String modifyAccount(HttpServletRequest request,Model model) throws ParseException{
        CivilsModel civil = new CivilsModel();
        civil.setCivilite(request.getParameter("civilite"));
        civil.setNom(request.getParameter("nom"));
        civil.setPrenom(request.getParameter("prenom"));
        civil.setEmail(request.getParameter("mail"));
        civil.setTel(request.getParameter("tel"));
        civil.setNationalite(request.getParameter("nationalite"));
        civil.setDateDeNaissance(request.getParameter("birth"));
        civil.setAdresse(request.getParameter("adresse"));
        AdminModel.modifyCivil(request.getParameter("modify"),civil);
        listeCivils = CivilsModel.getAllCivils();
        model.addAttribute("civil",listeCivils);
        return "panelAdmin/accounts";
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @RolesAllowed("ADMIN")
    @RequestMapping("/admin/modifyaccounts/{id}")
    public String viewModifyAccount(@PathVariable("id") String id,Model model){

        CivilsModel civil = AdminModel.findCivilById(id);
        model.addAttribute("civil",civil);
        return "panelAdmin/modifyAccount";
    }
    //=========================================================================
    //                          Methodes MISSIONS                                 =
    //=========================================================================

    /**
     * @param model
     * @return
     */
    @RolesAllowed("ADMIN")
    @GetMapping("/admin/missions")
    public String adminMission(Model model){
        listeMissions = MissionModel.getAllMissions();

        model.addAttribute("missions",listeMissions);
        return "panelAdmin/missions";
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @RolesAllowed("ADMIN")
    @RequestMapping(value = "/admin/deletemission/{id}")
    public String viewDeleteMission(@PathVariable("id") String id,Model model){

        MissionModel mission = AdminModel.findMissionById(id);
        model.addAttribute("mission",mission);
        return "panelAdmin/deleteMission";

    }

    /**
     * @param request
     * @param model
     * @return
     * @throws ParseException
     */
    @RolesAllowed("ADMIN")
    @RequestMapping(value = "/admin/missions/d", method = RequestMethod.POST)
    public String deleteMission(HttpServletRequest request,Model model) throws ParseException {
        if(request.getParameter("delete")!= null){
            AdminModel.deleteMission(request.getParameter("delete"));
            listeMissions = MissionModel.getAllMissions();
            model.addAttribute("missions",listeMissions);
        }
        return "panelAdmin/missions";
    }

    /**
     * @param model
     * @return
     */
    @RolesAllowed("ADMIN")
    @GetMapping("/admin/organisations")
    public String adminOrganisation(Model model){

        listeOrga = OrganisationModel.getAllOrga();

        model.addAttribute("orgas",listeOrga);
        return "panelAdmin/organisations";
    }
    public String adminCrise(){
        return "panelAdmin/crise";
    }

}
