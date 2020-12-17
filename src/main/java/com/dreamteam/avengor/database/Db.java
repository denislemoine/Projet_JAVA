package com.dreamteam.avengor.database;

import com.dreamteam.avengor.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Db {

    private static final String URL = "jdbc:mysql://185.31.40.53:3306/avengor_db";
    private static final String USERNAME = "avengor_paul";
    private static final String PASSWORD = "avengor76";
    private static Connection CON;


    //=========================================================================
    //                          QUERIES SAVE                                  =
    //=========================================================================


    public static int saveCivil(CivilsModel civilsModel){

        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //creation d'un civils
            if(civilsModel.getId_Civil() != 0){
                Date birth = Date.valueOf(civilsModel.getDateDeNaissance());
                PreparedStatement statement = CON.prepareStatement
                        ("INSERT INTO Civils (Nom, Prenom, Civilite, Adresse, Email, Tel, DateDeNaissance, Password, Nationalite) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1,civilsModel.getNom());
                statement.setString(2,civilsModel.getPrenom());
                statement.setString(3,civilsModel.getCivilite());
                statement.setString(4,civilsModel.getAdresse());
                statement.setString(5,civilsModel.getEmail());
                statement.setString(6,civilsModel.getTel());
                statement.setDate(7, birth);
                statement.setString(8,civilsModel.getencrytedPassword());
                statement.setString(9,civilsModel.getNationalite());
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

    public static void saveHero(SuperHerosModel superHerosModel){

        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if(superHerosModel.getId_SuperHeros() != 0){
                PreparedStatement statement = CON.prepareStatement
                        ("INSERT INTO Super_heros (Nom, IdentitéSecretes, Pouvoir, Point_faible, Score, Commentaire) " +
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
    //=========================================================================
    //                          QUERIES INCIDENT                              =
    //=========================================================================
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

    public static List<CivilsModel> getAllCivil(){
        List<CivilsModel> civils = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //renvoie de tout les civils
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Civils");
            while(resultSet.next()){
                CivilsModel civil = new CivilsModel(resultSet.getInt("id_Civil"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("civilite"),resultSet.getString("adresse"),
                        resultSet.getString("email"),resultSet.getString("tel"),resultSet.getString("dateDeNaissance"),null,resultSet.getString("Nationalite"));
                civils.add(civil);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return civils;
    }

    public static CivilsModel findCivilById(String id){
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Civils where id_Civil =" + id);

            if(resultSet.next()) {
                CivilsModel civil = new CivilsModel(resultSet.getInt("id_Civil"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("civilite"),resultSet.getString("adresse"),
                        resultSet.getString("email"),resultSet.getString("tel"),resultSet.getString("dateDeNaissance"),null,resultSet.getString("Nationalite"));
                return civil;
            } else {
                return null;
            }

        } catch (SQLException e) {

            e.printStackTrace();
            CivilsModel civil = new CivilsModel(0,"ERREUR",null,null,null,null,null,null,null,null);
            return civil;
        }
    }

    //=========================================================================
    //                          QUERIES HERO                                  =
    //=========================================================================

    public static List<SuperHerosModel> getAllHero(){
        List<SuperHerosModel> heros = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();

            ResultSet res = statement.executeQuery("SELECT * FROM Super_heros");

            while(res.next()){

                CivilsModel civil = findCivilById(res.getString("IdentitéSecretes"));

                SuperHerosModel hero = new SuperHerosModel(
                    res.getInt("id_SuperHeros"), res.getString("Nom"), res.getInt("IdentitéSecretes"),
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

    //=========================================================================
    //                          QUERIES MISSIONS                              =
    //=========================================================================

    public static List<MissionModel> getAllMission(){
        List<MissionModel> missions = new ArrayList<>();
        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = CON.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Missions");

            while(res.next()){

                MissionModel mission = new MissionModel(
                        res.getInt("id_Mission"), res.getString("Titre"), res.getTimestamp("DateDebut"),
                        res.getTimestamp("DateFin"), res.getInt("Niveaux"), res.getInt("Urgence"),
                        res.getInt("id_Incidents"), null
                );
                missions.add(mission);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return missions;
    }

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
                        res.getInt("id_SuperVilains"), res.getString("Nom"), res.getInt("IdentitéSecretes"),
                        res.getString("Pouvoir"), res.getString("Point-faible"), (float) res.getInt("Score"),
                        res.getString("Commentaire")
                );
                vilains.add(vilain);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vilains;
    }
}
