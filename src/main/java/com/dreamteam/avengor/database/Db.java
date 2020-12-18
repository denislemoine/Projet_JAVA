package com.dreamteam.avengor.database;

import com.dreamteam.avengor.model.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Db connection
 */
public class Db {

    private static final String URL = "jdbc:mysql://185.31.40.53:3306/avengor_db";
    private static final String USERNAME = "avengor_paul";
    private static final String PASSWORD = "avengor76";
    private static Connection CON;

    //=========================================================================
    //                          QUERY LOGIN                                   =
    //=========================================================================

    public static String login(String mail){
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement state = CON.createStatement();
            ResultSet res = state.executeQuery("SELECT Password, Email FROM Civils WHERE Email = '" + mail + "'");
            if(res.next()){
                if(res.getString("Email").equals(mail)) {
                    return res.getString("Password");
                }
            } else {
                return "null";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "null";
        }
        return "null";
    }

    /**
     * @param mail
     * @return
     */
    public static int getPrivilegeOfCivil(String mail){
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement state = CON.createStatement();
            ResultSet res = state.executeQuery("SELECT privilege, Email FROM Civils WHERE Email = '" + mail + "'");
            if(res.next()){
                if(res.getString("Email").equals(mail)) {
                    return res.getInt("privilege");
                }
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    //=========================================================================
    //                          QUERIES SAVE                                  =
    //=========================================================================


    /**
     * @param civilsModel
     * @return
     */
    public static int saveCivil(CivilsModel civilsModel){

        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //creation d'un civils
            if(civilsModel.getId_Civil() != 0){
                Date birth = Date.valueOf(civilsModel.getDateDeNaissance());
                PreparedStatement statement = CON.prepareStatement
                        ("INSERT INTO Civils (Nom, Prenom, Civilite, Adresse, Email, Tel, DateDeNaissance, Password, Nationalite, privilege) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1,civilsModel.getNom());
                statement.setString(2,civilsModel.getPrenom());
                statement.setString(3,civilsModel.getCivilite());
                statement.setString(4,civilsModel.getAdresse());
                statement.setString(5,civilsModel.getEmail());
                statement.setString(6,civilsModel.getTel());
                statement.setDate(7, birth);
                statement.setString(8,civilsModel.getencrytedPassword());
                statement.setString(9,civilsModel.getNationalite());
                statement.setInt(10,civilsModel.getPrivilege());
                statement.execute();

                Statement state = CON.createStatement();
                ResultSet res = state.executeQuery("SELECT Id_Civil FROM Civils WHERE Email = '" + civilsModel.getEmail() + "'");
                if(res.next()){
                    return res.getInt("Id_Civil");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param organisationModel
     * @return
     */
    public static int saveOrganisation(OrganisationModel organisationModel){

        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //creation d'une organisation
                PreparedStatement statement = CON.prepareStatement
                        ("INSERT INTO Organisations (Nom, Adresse, Dirigeant, Commentaire) " +
                                "VALUES (?, ?, ?, ?)");
                statement.setString(1,organisationModel.getNom());
                statement.setString(2,organisationModel.getAdresse());
                statement.setInt(3,organisationModel.getDirigeant());
                statement.setString(4,organisationModel.getCommentaire());

                statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param superHerosModel
     */
    public static void saveHero(SuperHerosModel superHerosModel){

        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if(superHerosModel.getId_SuperHeros() != 0){
                PreparedStatement statement = CON.prepareStatement
                        ("INSERT INTO Super_heros (Nom, IdentiteSecretes, Pouvoir, Point_faible, Score, Commentaire) " +
                                "VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1,superHerosModel.getNom());
                statement.setInt(2,superHerosModel.getIdentiteSecrete());
                statement.setString(3,superHerosModel.getPouvoir());
                statement.setString(4,superHerosModel.getPointFaible());
                statement.setFloat(5,superHerosModel.getScore());
                statement.setString(6,superHerosModel.getCommentaire());
                statement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param superVilainModel
     */
    public static void saveVilain(SuperVilainModel superVilainModel){

        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //if(superHerosModel.getId_SuperHeros() != 0){
                PreparedStatement statement = CON.prepareStatement
                        ("INSERT INTO Super_vilains (Nom, IdentiteSecretes, Pouvoir, Point_faible, Score, Commentaire) " +
                                "VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1,superVilainModel.getNom());
                statement.setInt(2,superVilainModel.getIdentiteSecrete());
                statement.setString(3,superVilainModel.getPouvoir());
                statement.setString(4,superVilainModel.getPointFaible());
                statement.setFloat(5,superVilainModel.getScore());
                statement.setString(6,superVilainModel.getCommentaire());
                statement.execute();
            //}

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param incidentModel
     */
    //=========================================================================
    //                          QUERIES INCIDENT                              =
    //=========================================================================
    // Ajout d'un incident
    public static void saveIncident(IncidentModel incidentModel){
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = CON.prepareStatement
                    ("INSERT INTO Incidents (Adresse,TypeIncident,id_Civils,Ennemis,InfoComplementaire) " +
                            "VALUES (?,?,?,?,?)");
            statement.setString(1,incidentModel.getAdresse());
            statement.setString(2,incidentModel.getTypeIncident());
            statement.setInt(3,incidentModel.getId_Civils());
            if (incidentModel.getEnnemis() != null) {
                statement.setInt(4,incidentModel.getEnnemis());
            } else {
                statement.setNull(4,Types.NULL);
            }
            statement.setString(5,incidentModel.getInfoComplementaire());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param id
     */
    // Suppression d'un incident avec son identifiant
    public static void deleteIncidentByID(String id){
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = CON.prepareStatement("DELETE FROM Incidents WHERE id_Incidents = ?");
            statement.setString(1,id);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    // Liste de tous les incidents
    public static List<IncidentModel> getAllIncidents(){
        List<IncidentModel> incidents = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Incidents");

            while(res.next()){
                IncidentModel incident = new IncidentModel(
                        res.getInt("id_Incidents"), res.getString("Adresse"), res.getString("TypeIncident"),
                        res.getInt("id_Civils"), res.getInt("Ennemis"), res.getInt("Mission"), res.getString("InfoComplementaire")
                );
                incidents.add(incident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidents;
    }

    /**
     * @param id
     * @return
     */
    // Un incident particulié avec son identifiant
    public static IncidentModel getIncidentByID(String id){
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Incidents WHERE id_Incidents ="+ id);

            if(res.next()){
                IncidentModel incident = new IncidentModel(
                        res.getInt("id_Incidents"), res.getString("Adresse"), res.getString("TypeIncident"),
                        res.getInt("id_Civils"), res.getInt("Ennemis"), res.getInt("Mission"), res.getString("InfoComplementaire")
                );
                return incident;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //=========================================================================
    //                          QUERIES CIVIL                                 =
    //=========================================================================

    /**
     * @return
     */
    public static List<CivilsModel> getAllCivil(){
        List<CivilsModel> civils = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //renvoie de tout les civils
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Civils");
            while(resultSet.next()){
                if(resultSet.getString("Password") != null){
                    CivilsModel civil = new CivilsModel(resultSet.getInt("id_Civil"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("civilite"),resultSet.getString("adresse"),
                            resultSet.getString("email"),resultSet.getString("tel"),resultSet.getString("dateDeNaissance"),null,resultSet.getString("Nationalite"), resultSet.getInt("privilege"));
                    civils.add(civil);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return civils;
    }

    /**
     * @param id
     * @return
     */
    public static CivilsModel findCivilById(String id){
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Civils where id_Civil =" + id);

            if(resultSet.next()) {
                CivilsModel civil = new CivilsModel(resultSet.getInt("id_Civil"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("civilite"),resultSet.getString("adresse"),
                        resultSet.getString("email"),resultSet.getString("tel"),resultSet.getString("dateDeNaissance"),null,resultSet.getString("Nationalite"), resultSet.getInt("privilege"));
                return civil;
            } else {
                return null;
            }

        } catch (SQLException e) {

            e.printStackTrace();
            CivilsModel civil = new CivilsModel(0,"ERREUR",null,null,null,null,null,null,null,null, 0);
            return civil;
        }
    }

    /**
     * @param mail
     * @return
     */
    public static CivilsModel findCivilByMail(String mail){
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Civils WHERE Email = '" + mail + "'");

            if(resultSet.next()) {
                CivilsModel civil = new CivilsModel(resultSet.getInt("id_Civil"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("civilite"),resultSet.getString("adresse"),
                        resultSet.getString("email"),resultSet.getString("tel"),resultSet.getString("dateDeNaissance"),null,resultSet.getString("Nationalite"), resultSet.getInt("privilege"));
                return civil;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param id
     */
    public static void deleteCivil(String id){

        try {
            java.util.Date date = new java.util.Date();
            long now = date.getTime();
            Timestamp dateDelete = new Timestamp(now);
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement statement = CON.prepareStatement
                    ("Update Civils set Password = null, Nom = null, Prenom = null, Civilite = null, Adresse = null, Email = null," +
                            " Tel = null, DateDeNaissance = null,DateDeDeces = null,Orga = null,Nationalite = null,Commentaire = null, DateAjout = null, DateDerniereModif = ?" +
                            "Where id_Civil = ?");
            statement.setTimestamp(1,dateDelete);
            statement.setString(2,id);
            statement.execute();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        
    }

    /**
     * @param id
     * @param civil
     */
    public static void modifyCivil(String id,CivilsModel civil){

        try {
            java.util.Date date = new java.util.Date();
            long now = date.getTime();
            Timestamp dateModif = new Timestamp(now);
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement statement = CON.prepareStatement
                    ("Update Civils set Nom = ?, Prenom = ?, Civilite = ?, Adresse = ?, Email = ?," +
                            " Tel = ?, DateDeNaissance = ?,Nationalite = ?, DateDerniereModif = ?"+
                            "where id_Civil = ?");
            statement.setString(1,civil.getNom());
            statement.setString(2,civil.getPrenom());
            statement.setString(3,civil.getCivilite());
            statement.setString(4,civil.getAdresse());
            statement.setString(5,civil.getEmail());
            statement.setString(6,civil.getTel());
            statement.setString(7,civil.getDateDeNaissance());
            statement.setString(8,civil.getNationalite());
            statement.setTimestamp(9,dateModif);
            statement.setString(10,id);
            statement.execute();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    /**
     * @param idUser
     * @param newRoleId
     * @return
     */
    public static boolean updatePrivilege(String idUser, int newRoleId){

        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement statement = CON.prepareStatement
                    ("UPDATE Civils SET privilege = ?" +
                            " WHERE id_Civil = ?");
            statement.setInt(1, newRoleId);
            statement.setString(2, idUser);
            statement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //=========================================================================
    //                          QUERIES HERO                                  =
    //=========================================================================

    /**
     * @return
     */
    public static List<SuperHerosModel> getAllHero(){
        List<SuperHerosModel> heros = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();

            ResultSet res = statement.executeQuery("SELECT * FROM Super_heros");

            while(res.next()){

                CivilsModel civil = findCivilById(res.getString("IdentiteSecretes"));

                SuperHerosModel hero = new SuperHerosModel(
                    res.getInt("id_SuperHeros"), res.getString("Nom"), res.getInt("IdentiteSecretes"),
                        res.getString("Pouvoir"), res.getString("Point_faible"), res.getFloat("Score"),
                        res.getString("Commentaire"), civil
                );
                heros.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heros;
    }

    /**
     * @param id
     * @return
     */
    public static SuperHerosModel findHeroById(int id){
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet res = statement.executeQuery("select * from Super_heros where id_SuperHeros = " + id);

            if(res.next()) {
                return new SuperHerosModel(
                        res.getInt("id_SuperHeros"), res.getString("Nom"), res.getInt("IdentiteSecretes"),
                        res.getString("Pouvoir"), res.getString("Point_faible"), res.getFloat("Score"),
                        res.getString("Commentaire"), null
                );
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //=========================================================================
    //                          QUERIES MISSIONS                              =
    //=========================================================================

    /**
     * @return
     */
    public static List<MissionModel> getAllMission(){
        List<MissionModel> missions = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Missions");

            while(res.next()){

                SuperHerosModel hero = Db.getHeroFromMission(res.getInt("id_Mission"));

                MissionModel mission = new MissionModel(
                        res.getInt("id_Mission"), res.getString("Titre"), res.getTimestamp("DateDebut"),
                        res.getTimestamp("DateFin"), res.getInt("Niveaux"), res.getInt("Urgence"),
                        res.getInt("id_Incidents"),res.getString("RapportFinMission"), hero
                );
                if(res.getTimestamp("DateFin") == null){
                    missions.add(mission);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return missions;
    }

    /**
     * @param idMission
     * @return
     * @throws SQLException
     */
    public static SuperHerosModel getHeroFromMission(int idMission) throws SQLException {

        CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = CON.createStatement();

        ResultSet result = statement.executeQuery("SELECT * FROM SH_Mission WHERE Missions_id_Mission = " + idMission);
        if(result.next()) {
            int heroId = result.getInt("Super_heros_id_SuperHeros");

            return Db.findHeroById(heroId);

        }
        return null;
    }

    /**
     * @param missionModel
     * @param idHero
     */
    public static void saveMission(MissionModel missionModel, int idHero){
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = CON.prepareStatement
                    ("INSERT INTO Missions (Titre, DateDebut, Niveaux, Urgence, id_Incidents) " +
                            "VALUES (?,?,?,?,?)");
            statement.setString(1,missionModel.getTitre());
            statement.setTimestamp(2,missionModel.getDateDebut());
            statement.setInt(3,missionModel.getNiveaux());
            statement.setInt(4,missionModel.getUrgence());
            statement.setInt(5,missionModel.getId_Incidents());
            statement.execute();

            ResultSet res = statement.executeQuery("SELECT id_Mission FROM Missions WHERE id_Incidents = " + missionModel.getId_Incidents());

            if(res.next()) {
                int id_mission = res.getInt("id_Mission");

                PreparedStatement state = CON.prepareStatement
                        ("UPDATE Incidents SET Mission = (?) WHERE id_Incidents = (?)");
                state.setInt(1, id_mission);
                state.setInt(2, missionModel.getId_Incidents());
                state.execute();
            }

            try {
                CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                int id_mission = res.getInt("id_Mission");
                PreparedStatement state = CON.prepareStatement
                        ("INSERT INTO SH_Mission (Super_heros_id_SuperHeros, Missions_id_Mission) " +
                                "VALUES (?,?)");
                state.setInt(1, idHero);
                state.setInt(2, id_mission);
                state.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param id
     * @return
     */
    public static MissionModel findMissionById(String id){
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Missions where id_Mission =" + id);

            if(resultSet.next()) {
                MissionModel mission = new MissionModel(resultSet.getInt("id_Mission"),resultSet.getString("titre"),resultSet.getTimestamp("dateDebut"),resultSet.getTimestamp("dateFin"),resultSet.getInt("niveaux"),
                        resultSet.getInt("urgence"),resultSet.getInt("id_incidents"), resultSet.getString("RapportFinMission"),null);
                return mission;
            } else {
                return null;
            }

        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param id
     */
    public static void deleteMission(String id){

        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement statement = CON.prepareStatement
                    ("Update Missions set Titre = null, DateDebut = null, DateFin = null, Niveaux = null, Urgence = null "+
                            "Where id_Mission = ?");
            statement.setString(1,id);
            statement.execute();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    /**
     * @param id
     * @param mission
     */
    public static void modifyMission(String id,MissionModel mission){

        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement statement = CON.prepareStatement
                    ("Update Missions set Titre = ?, DateDebut = ?, DateFin = ?, Niveaux = ?, Urgence = ?," +
                            "where id_Civil = ?");
            statement.setString(1,mission.getTitre());
            /*statement.setString(2,mission.getDateDebut());
            statement.setString(3,mission.getDateFin());
            statement.setString(4,mission.getNiveaux());
            statement.setString(5,mission.getUrgence());*/
            statement.setString(6,id);
            statement.execute();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    /**
     * @param id
     * @param rapport
     */
    public static void finishMission(String id, String rapport){
        try {
            java.util.Date date = new java.util.Date();
            long now = date.getTime();
            Timestamp dateModif = new Timestamp(now);
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement statement = CON.prepareStatement
                    ("Update Missions set DateFin = ?,RapportFinMission = ?" +
                            "where id_Mission = ?");
            statement.setTimestamp(1,dateModif);
            statement.setString(2,rapport);
            statement.setString(3,id);
            statement.execute();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    //=========================================================================
    //                          QUERIES DES SUPERVILAINS                      =
    //=========================================================================
    public static List<SuperVilainModel> getAllVilains(){
        List<SuperVilainModel> vilains = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Super_vilains");

            while(res.next()){
                SuperVilainModel vilain = new SuperVilainModel(
                        res.getInt("id_SuperVilains"), res.getString("Nom"), res.getInt("IdentiteSecretes"),
                        res.getString("Pouvoir"), res.getString("Point_faible"), (float) res.getInt("Score"),
                        res.getString("Commentaire")
                );
                vilains.add(vilain);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vilains;
    }

    /**
     * @param satisfactionModel
     */
    //=========================================================================
    //                          QUERIES DES SATISFACTIONS                     =
    //=========================================================================
    // Ajout d'une satisfaction
    public static void saveSatisfaction(SatisfactionModel satisfactionModel){
        int civilNote = 0;
        int id = 0;
        int vilainNote = 0;
        int scoreSend = 0;
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = CON.prepareStatement
                    ("INSERT INTO Satisfaction (id_Civil,id_super_vilain,id_Incidents,id_Mission,satisfactionType,Message,Note,Commentaire) " +
                            "VALUES (?,?,?,?,?,?,?,?)");
            if (satisfactionModel.getId_Civil() != null) {
                statement.setInt(1,satisfactionModel.getId_Civil());
                civilNote = 1;
                id = satisfactionModel.getId_Civil();
            } else { statement.setNull(1,Types.NULL); }

            if (satisfactionModel.getId_super_vilain() != null) {
                statement.setInt(2,satisfactionModel.getId_super_vilain());
                vilainNote = 1;
                id = satisfactionModel.getId_super_vilain();
            } else { statement.setNull(2,Types.NULL); }

            if (satisfactionModel.getId_Incidents() != null) { statement.setInt(3,satisfactionModel.getId_Incidents()); }
            else { statement.setNull(3,Types.NULL); }

            if (satisfactionModel.getId_Mission() != null) { statement.setInt(4,satisfactionModel.getId_Mission()); }
            else { statement.setNull(4,Types.NULL); }

            statement.setString(5,satisfactionModel.getSatisfactionType());
            statement.setString(6,satisfactionModel.getMessage());

            if (satisfactionModel.getNote() != null) {
                statement.setInt(7,satisfactionModel.getNote());
                scoreSend = satisfactionModel.getNote();
            } else { statement.setNull(7,Types.NULL); }

            statement.setString(8,satisfactionModel.getCommentaire());
            statement.execute();

            if (civilNote != 0) {
                CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statementFindScore = CON.createStatement();
                ResultSet resultSet = statementFindScore.executeQuery("select * from Super_heros where IdentiteSecretes =" + id);
                if(resultSet.next()) {
                    int score = resultSet.getInt("Score");
                    scoreSend += score;
                    PreparedStatement state = CON.prepareStatement
                            ("UPDATE Super_heros SET Score = (?) WHERE IdentiteSecretes = (?)");
                    state.setInt(1, scoreSend);
                    state.setInt(2, id);
                    state.execute();
                }
            }
            if (vilainNote != 0){
                CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statementFindScore = CON.createStatement();
                ResultSet resultSet = statementFindScore.executeQuery("select * from Super_heros where IdentiteSecretes =" + id);
                if(resultSet.next()) {
                    int score = resultSet.getInt("Score");
                    scoreSend += score;
                    PreparedStatement state = CON.prepareStatement
                            ("UPDATE Super_vilains SET Score = (?) WHERE id_SuperVilains = (?)");
                    state.setInt(1, scoreSend);
                    state.setInt(2, id);
                    state.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param id
     * @return
     */
    public static List<SatisfactionModel> getSatisfactionByIncidentID(String id){
        List<SatisfactionModel> satisfactions = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Satisfaction WHERE id_Incidents ="+ id);

            while(res.next()){
                SatisfactionModel satisfaction = new SatisfactionModel(
                        res.getInt("id_Satisfaction")
                        ,res.getInt("id_Civil")
                        ,res.getInt("id_super_vilain")
                        ,res.getInt("id_Incidents")
                        ,res.getInt("id_Mission")
                        ,res.getString("satisfactionType")
                        ,res.getString("Message")
                        ,res.getInt("Note")
                        ,res.getString("Commentaire")
                );
                satisfactions.add(satisfaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return satisfactions;
    }

    /**
     * @param id
     * @return
     */
    public static List<SatisfactionModel> getSatisfactionByMissionID(String id){
        List<SatisfactionModel> satisfactions = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Satisfaction WHERE id_Mission ="+ id);

            while(res.next()){
                SatisfactionModel satisfaction = new SatisfactionModel(
                        res.getInt("id_Satisfaction")
                        ,res.getInt("id_Civil")
                        ,res.getInt("id_super_vilain")
                        ,res.getInt("id_Incidents")
                        ,res.getInt("id_Mission")
                        ,res.getString("satisfactionType")
                        ,res.getString("Message")
                        ,res.getInt("Note")
                        ,res.getString("Commentaire")
                );
                satisfactions.add(satisfaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return satisfactions;
    }

    /**
     * @param id
     * @return
     */
    public static List<SatisfactionModel> getSatisfactionByCivilID(String id){
        List<SatisfactionModel> satisfactions = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Satisfaction WHERE id_Civil ="+ id);

            while(res.next()){
                SatisfactionModel satisfaction = new SatisfactionModel(
                        res.getInt("id_Satisfaction")
                        ,res.getInt("id_Civil")
                        ,res.getInt("id_super_vilain")
                        ,res.getInt("id_Incidents")
                        ,res.getInt("id_Mission")
                        ,res.getString("satisfactionType")
                        ,res.getString("Message")
                        ,res.getInt("Note")
                        ,res.getString("Commentaire")
                );
                satisfactions.add(satisfaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return satisfactions;
    }

    /**
     * @param id
     * @return
     */
    public static List<SatisfactionModel> getSatisfactionByVilainID(String id){
        List<SatisfactionModel> satisfactions = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Satisfaction WHERE id_super_vilain ="+ id);

            while(res.next()){
                SatisfactionModel satisfaction = new SatisfactionModel(
                        res.getInt("id_Satisfaction")
                        ,res.getInt("id_Civil")
                        ,res.getInt("id_super_vilain")
                        ,res.getInt("id_Incidents")
                        ,res.getInt("id_Mission")
                        ,res.getString("satisfactionType")
                        ,res.getString("Message")
                        ,res.getInt("Note")
                        ,res.getString("Commentaire")
                );
                satisfactions.add(satisfaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return satisfactions;
    }

    /**
     * @return
     */
    //=========================================================================
    //                          QUERIES DES ORGANISATION                      =
    //=========================================================================
    public static List<OrganisationModel> getAllOrga() {
        List<OrganisationModel> orgas = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //renvoie de toute les orga
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Organisations");
            while (resultSet.next()) {
                if (resultSet.getString("Nom") != null) {
                    OrganisationModel orga = new OrganisationModel(resultSet.getInt("id_Organisations"), resultSet.getString("Nom"), resultSet.getString("Adresse"), resultSet.getInt("Dirigeant"), resultSet.getString("Commentaire"),
                            resultSet.getTimestamp("DateAjout"), resultSet.getTimestamp("DATEDerniereModif"), resultSet.getInt("NbIncidentsDeclares"), resultSet.getInt("NbMissionsImplique"));
                    orgas.add(orga);

                }

            }
            return orgas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     */
    public static List<OrganisationModel> getAllOrganisations(){
        List<OrganisationModel> organisations = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Organisations");

            while(res.next()){
                OrganisationModel organisation = new OrganisationModel(
                    res.getInt("id_Organisations"), res.getString("Nom"), res.getString("Adresse"), res.getInt("Dirigeant"),
                    res.getString("Commentaire"), res.getTimestamp("DateAjout"), res.getTimestamp("DATEDerniereModif"),
                    res.getInt("NbIncidentsDeclares"), res.getInt("NbMissionsImplique")
                );
                organisations.add(organisation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return organisations;
    }

}
