package com.dreamteam.avengor.database;

import com.dreamteam.avengor.model.CivilsModel;
import com.dreamteam.avengor.model.IncidentModel;
import com.dreamteam.avengor.model.SuperHerosModel;

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


    public static void saveCivil(CivilsModel civilsModel){

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
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveHero(SuperHerosModel superHerosModel){

        try {
            CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //creation d'un civils
            if(superHerosModel.getId_SuperHeros() != 0){
                PreparedStatement statement = CON.prepareStatement
                        ("INSERT INTO Super-heros (Nom, IdentitéSecretes, Pouvoir, Point-faible, , Commentaire) " +
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
            statement.setInt(2,incidentModel.getTypeIncident());
            statement.setInt(3,incidentModel.getId_Civils());
            statement.setInt(4,incidentModel.getEnnemis());
            statement.setString(5,incidentModel.getInfoComplementaire());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
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
            //renvoie un civil
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Civils where  id_Civil =" + id);
            CivilsModel civil = new CivilsModel(resultSet.getInt("id_Civil"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("civilite"),resultSet.getString("adresse"),
                    resultSet.getString("email"),resultSet.getString("tel"),resultSet.getString("dateDeNaissance"),null,resultSet.getString("Nationalite"));
            return civil;
        } catch (SQLException e) {

            e.printStackTrace();
            CivilsModel civil = new CivilsModel(0,"erreur",null,null,null,null,null,null,null,null);
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

            ResultSet resultSet = statement.executeQuery("select * from Super-heros");

            while(resultSet.next()){
                SuperHerosModel hero = new SuperHerosModel(
                    1, null, 0, null, null, null, null
                );
                heros.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heros;
    }

}
